package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.security.UsuarioActual;
import mx.com.pelayo.repository.SecurityRepository;

@Singleton
public class SecurityViewModel extends ViewModel {

    private SecurityRepository securityRepository;

    private LiveData<List<Usuario>> usuarios;

    @Inject
    public SecurityViewModel(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    public Observable login(String username, String password, String basic) {
        return securityRepository.login(username, password, basic);
    }

    public LiveData<UsuarioActualComposed> getUsuarioActual(){
        return securityRepository.getUsuarioActual();
    }

}
