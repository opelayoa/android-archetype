package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.SecurityService;
import mx.com.pelayo.database.dao.security.SessionDao;
import mx.com.pelayo.database.dao.security.SyncDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.Tipotd;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.database.entities.security.Sync;
import mx.com.pelayo.database.entities.security.UsuarioActual;

@Singleton
public class SecurityRepository {

    public ExecutorService executor;
    public SecurityService securityService;
    public SessionDao sessionDao;
    public UsuarioActualDao usuarioActualDao;
    public SyncDao syncDao;

    private LiveData<UsuarioActualComposed> usuarioActual;

    @Inject
    public SecurityRepository(ExecutorService executor, SecurityService securityService, SessionDao sessionDao,
                              UsuarioActualDao usuarioActualDao, SyncDao syncDao) {
        this.executor = executor;
        this.securityService = securityService;
        this.sessionDao = sessionDao;
        this.usuarioActualDao = usuarioActualDao;
        this.syncDao = syncDao;
        this.usuarioActual = usuarioActualDao.getUsuarioActualLiveData();
    }

    public Observable<Sync> login(String username, String password, String basic) {
        return this.securityService
                .login(username, password, "password", basic)
                .map(session -> {
                    sessionDao.deleteAll();
                    sessionDao.insert(session);
                    return session;
                })
                .flatMap(session -> this.securityService.getInfo("Bearer " + session.getAccessToken()))
                .map(usuarioActual -> {
                    LiveData<List<Tipotd>> tipoListLiveData = usuarioActualDao.getAllByPerfil(18);
                    usuarioActualDao.deleteAll();
                    return usuarioActualDao.insert(usuarioActual);
                })
                .map(data -> {
                    Sync sync = syncDao.getSyncByUserId(Integer.valueOf(data.toString()));
                    if (sync == null) {
                        sync = new Sync();
                        sync.setStatus(0);
                    }
                    return sync;
                });

    }

    public LiveData<UsuarioActualComposed> getUsuarioActual() {
        return usuarioActual;
    }

    public UsuarioActual getUsuarioActualSynchronous() {
        try {
            return executor.submit(() -> usuarioActualDao.getUsuarioActual()).get();
        } catch (ExecutionException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public UserInformation getUsuarioInfo() {
        try {
            return executor.submit(() -> usuarioActualDao.getUsuarioInfo()).get();
        } catch (ExecutionException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public LiveData<UserInformation> getUserInformation() {
        return usuarioActualDao.getUserInfo();
    }

}
