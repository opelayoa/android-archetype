package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.dao.DiagnosticoDao;
import mx.com.pelayo.database.dao.SintomaDao;
import mx.com.pelayo.database.dao.TipotdDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Singleton
public class GridRepository {

    private LiveData<List<Usuario>> usuarios;

    public Executor executor;
    public TipotdDao tipotdDao;
    public SintomaDao sintomaDao;
    public DiagnosticoDao diagnosticoDao;
    public UsuarioActualDao usuarioActualDao;

    @Inject
    public GridRepository(Executor executor, TipotdDao tipotdDao, SintomaDao sintomaDao, DiagnosticoDao diagnosticoDao, UsuarioActualDao usuarioActualDao) {
        this.executor = executor;
        this.tipotdDao = tipotdDao;
        this.sintomaDao = sintomaDao;
        this.diagnosticoDao = diagnosticoDao;
        this.usuarioActualDao = usuarioActualDao;
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
}
