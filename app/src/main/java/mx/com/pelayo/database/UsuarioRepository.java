package mx.com.pelayo.database;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.entities.Usuario;

public class UsuarioRepository {

    private LiveData<List<Usuario>> usuarios;

    @Inject
    public UsuarioDao usuarioDao;

    public UsuarioRepository(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
        this.usuarios = usuarioDao.getAll();
    }

    LiveData<List<Usuario>> getAll() {
        return usuarios;
    }

    public void insert(final Usuario usuario) {
        Executor executor = runnable -> usuarioDao.insert(usuario);

    }




}
