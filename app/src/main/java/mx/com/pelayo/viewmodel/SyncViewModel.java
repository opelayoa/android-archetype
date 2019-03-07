package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.repository.SyncRepository;

@Singleton
public class SyncViewModel extends ViewModel {

    SyncRepository syncRepository;

    private LiveData<List<Usuario>> usuarios;

    @Inject
    public SyncViewModel(SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    public Observable sync() {
        return syncRepository.sync();
    }

}
