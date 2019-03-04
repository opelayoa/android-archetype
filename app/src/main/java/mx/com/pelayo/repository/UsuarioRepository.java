package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.api.TdeService;
import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.entities.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UsuarioRepository {

    private LiveData<List<Usuario>> usuarios;

    private Executor executor;

    private UsuarioDao usuarioDao;

    private TdeService tdeService;


    @Inject
    public UsuarioRepository(UsuarioDao usuarioDao, Executor executor, TdeService tdeService) {
        this.tdeService = tdeService;
        this.usuarioDao = usuarioDao;
        this.usuarios = usuarioDao.getAll();
        this.executor = executor;
    }

    public LiveData<List<Usuario>> getAll() {
        return usuarios;
    }

    public void insert(final Usuario usuario) {
        executor.execute(() -> usuarioDao.insert(usuario));
    }

    public void insertAll(final List<Usuario> usuarios) {
        executor.execute(() -> usuarioDao.insertAll(usuarios));
    }

    public void sync(){
        this.tdeService.getAllUsuarios().enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    Log.i("api-insert->", "onResponse: ok");
                    executor.execute(() -> usuarioDao.insertAll(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.i("api-insert->", "onResponse: error: " + t.getMessage());
            }
        });
    }
}
