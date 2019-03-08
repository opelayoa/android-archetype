package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.SecurityService;
import mx.com.pelayo.database.dao.security.SessionDao;
import mx.com.pelayo.database.entities.Usuario;

@Singleton
public class SecurityRepository {

    public Executor executor;
    public SecurityService securityService;
    public SessionDao sessionDao;

    @Inject
    public SecurityRepository(Executor executor, SecurityService securityService, SessionDao sessionDao) {
        this.executor = executor;
        this.securityService = securityService;
        this.sessionDao = sessionDao;
    }

    public Observable login(String username, String password, String basic) {
        return this.securityService
                .login(username, password, "password", basic)
                .map(session -> {
                    sessionDao.deleteAll();
                    sessionDao.insert(session);
                    return true;
                });

    }
}
