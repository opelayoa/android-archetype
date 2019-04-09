package mx.com.pelayo.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.content.SharedPreferences;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.SecurityService;
import mx.com.pelayo.database.dao.security.SessionDao;
import mx.com.pelayo.database.dao.security.SyncDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.database.entities.security.Sync;
import mx.com.pelayo.database.entities.security.UsuarioActual;
import mx.com.pelayo.util.Constants;

@Singleton
public class SecurityRepository {

    public ExecutorService executor;
    public SecurityService securityService;
    public SessionDao sessionDao;
    public UsuarioActualDao usuarioActualDao;
    public SyncDao syncDao;
    public SharedPreferences sharedPreferences;

    private LiveData<UsuarioActualComposed> usuarioActual;
    private LiveData<UserInformation> userInformationLiveData;

    @Inject
    public SecurityRepository(ExecutorService executor, SecurityService securityService, SessionDao sessionDao,
                              UsuarioActualDao usuarioActualDao, SyncDao syncDao, SharedPreferences sharedPreferences) {
        this.executor = executor;
        this.securityService = securityService;
        this.sessionDao = sessionDao;
        this.usuarioActualDao = usuarioActualDao;
        this.syncDao = syncDao;
        this.usuarioActual = usuarioActualDao.getUsuarioActualLiveData();
        this.userInformationLiveData = usuarioActualDao.getUserInfo();
        this.sharedPreferences = sharedPreferences;
    }

    @SuppressLint("ApplySharedPref")
    public Observable<Sync> login(String username, String password, String basic) {
        return this.securityService
                .login(username, password, "password", basic)
                .map(session -> {
                    sessionDao.deleteAll();
                    sessionDao.insert(session);
                    return session;
                })
                .flatMap(session -> this.securityService.getInfo(String.format(Constants.AUTHENTICATION_BEARER, session.getAccessToken())))
                .map(usuarioActual -> {
                    sharedPreferences
                            .edit()
                            .putString(Constants.USERNAME_SP, username)
                            .putString(Constants.PASSWORD_SP, password)
                            .commit();
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

    public LiveData<UserInformation> getUserInformationLiveData() {
        return userInformationLiveData;
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
