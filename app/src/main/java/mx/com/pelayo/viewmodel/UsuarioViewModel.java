package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.repository.UsuarioRepository;
import mx.com.pelayo.database.entities.Usuario;

@Singleton
public class UsuarioViewModel extends ViewModel {

    UsuarioRepository usuarioRepository;

    private LiveData<List<Usuario>> usuarios;

    @Inject
    public UsuarioViewModel(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarios = usuarioRepository.getAll();
    }

    public void sync() {
        usuarioRepository.sync();
    }

    public LiveData<List<Usuario>> getAll() {
        return usuarios;
    }

    public void insert(Usuario usuario) {
        usuarioRepository.insert(usuario);
    }

    public void insertAll(List<Usuario> usuarios) {
        usuarioRepository.insertAll(usuarios);
    }

}
