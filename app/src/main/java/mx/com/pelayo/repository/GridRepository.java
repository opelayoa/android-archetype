package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.dao.DiagnosticoDao;
import mx.com.pelayo.database.dao.EstadoDao;
import mx.com.pelayo.database.dao.SintomaDao;
import mx.com.pelayo.database.dao.TipotdDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Singleton
public class GridRepository {

    public ExecutorService executorService;
    public TipotdDao tipotdDao;
    public SintomaDao sintomaDao;
    public DiagnosticoDao diagnosticoDao;
    public UsuarioActualDao usuarioActualDao;
    public EstadoDao estadoDao;
    private LiveData<List<Usuario>> usuarios;

    @Inject
    public GridRepository(ExecutorService executorService, TipotdDao tipotdDao, SintomaDao sintomaDao,
                          DiagnosticoDao diagnosticoDao, UsuarioActualDao usuarioActualDao, EstadoDao estadoDao) {
        this.executorService = executorService;
        this.tipotdDao = tipotdDao;
        this.sintomaDao = sintomaDao;
        this.diagnosticoDao = diagnosticoDao;
        this.usuarioActualDao = usuarioActualDao;
        this.estadoDao = estadoDao;
    }

    public LiveData<List<ItemGrid>> getAllGridTipo(Integer perfilId) {
        return tipotdDao.getAllGridByPerfil(perfilId);

    }

    public LiveData<List<ItemGrid>> getAllGridSintoma(Integer tipoId, Integer perfilId) {
        return sintomaDao.getAllGridByPerfil(tipoId, perfilId);
    }

    public LiveData<List<ItemGrid>> getAllGridDiagnostico(Integer sintomaId, Integer perfilId) {
        return diagnosticoDao.getAllGrid(sintomaId, perfilId);

    }

    public LiveData<List<ItemGrid>> getAllGridTicketStates() {
        return estadoDao.getAllTicketStates();
    }
}
