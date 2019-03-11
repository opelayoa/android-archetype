package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.repository.GridRepository;
import mx.com.pelayo.repository.UsuarioRepository;

@Singleton
public class GridViewModel extends ViewModel {

    GridRepository gridRepository;




    @Inject
    public GridViewModel(GridRepository gridRepository) {
        this.gridRepository = gridRepository;
    }

    public LiveData<List<ItemGrid>> getAllTiposGrid(Integer perfilId) {
        return gridRepository.getAllGridTipo(perfilId);
    }

    public LiveData<List<ItemGrid>> getAllSintomasGrid(Integer tipoId, Integer perfilId) {
        return gridRepository.getAllGridSintoma(tipoId, perfilId);
    }

    public LiveData<List<ItemGrid>> getAllDiagnosticosGrid(Integer sintomaId, Integer perfilId) {
        return gridRepository.getAllGridDiagnostico(sintomaId, perfilId);
    }
}
