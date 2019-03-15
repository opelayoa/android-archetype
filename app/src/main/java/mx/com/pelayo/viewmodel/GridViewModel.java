package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.repository.GridRepository;

@Singleton
public class GridViewModel extends ViewModel {

    GridRepository gridRepository;

    @Inject
    public GridViewModel(GridRepository gridRepository) {
        this.gridRepository = gridRepository;
    }

    public List<ItemGrid> getAllTiposGrid(Integer perfilId) {
        return gridRepository.getAllGridTipo(perfilId);

    }

    public List<ItemGrid> getAllSintomasGrid(Integer tipoId, Integer perfilId) {
        return gridRepository.getAllGridSintoma(tipoId, perfilId);
    }

    public List<ItemGrid> getAllDiagnosticosGrid(Integer sintomaId, Integer perfilId) {
        return gridRepository.getAllGridDiagnostico(sintomaId, perfilId);
    }
}
