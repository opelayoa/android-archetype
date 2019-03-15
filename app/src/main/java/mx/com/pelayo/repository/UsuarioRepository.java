package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import mx.com.pelayo.api.TdeService;
import mx.com.pelayo.database.dao.DistritoDao;
import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.entities.Usuario;

@Singleton
public class UsuarioRepository {

    private LiveData<List<Usuario>> usuarios;

    public ExecutorService executor;
    public UsuarioDao usuarioDao;
    public DistritoDao distritoDao;
    public TdeService tdeService;

    @Inject
    public UsuarioRepository(ExecutorService executor, UsuarioDao usuarioDao, DistritoDao distritoDao, TdeService tdeService) {
        this.executor = executor;
        this.usuarioDao = usuarioDao;
        this.distritoDao = distritoDao;
        this.tdeService = tdeService;
        this.usuarios = usuarioDao.getAll();
    }

    public LiveData<List<Usuario>> getAll() {
        return usuarios;
    }

    public Completable insert(final Usuario usuario) {
        return Completable.fromAction(() -> usuarioDao.insert(usuario));
    }

    public void insertAll(final List<Usuario> usuarios) {
        executor.execute(() -> usuarioDao.insertAll(usuarios));
    }

    public Observable sync() {
        return this.tdeService.getAllUsuarios()
                .map(usuarios -> usuarioDao.insertAll(usuarios))
                .flatMap(data -> tdeService.getAllDistritos())
                .map(distritos -> distritoDao.insertAll(distritos));


    }
}
