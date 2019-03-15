package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

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

    public ExecutorService executorService;
    public TipotdDao tipotdDao;
    public SintomaDao sintomaDao;
    public DiagnosticoDao diagnosticoDao;
    public UsuarioActualDao usuarioActualDao;
    private LiveData<List<Usuario>> usuarios;

    @Inject
    public GridRepository(ExecutorService executorService, TipotdDao tipotdDao, SintomaDao sintomaDao, DiagnosticoDao diagnosticoDao, UsuarioActualDao usuarioActualDao) {
        this.executorService = executorService;
        this.tipotdDao = tipotdDao;
        this.sintomaDao = sintomaDao;
        this.diagnosticoDao = diagnosticoDao;
        this.usuarioActualDao = usuarioActualDao;
    }

    public List<ItemGrid> getAllGridTipo(Integer perfilId) {
        try {
            return executorService.submit(() -> tipotdDao.getAllGridByPerfil(perfilId)).get();
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public List<ItemGrid> getAllGridSintoma(Integer tipoId, Integer perfilId) {
        try {
            return executorService.submit(() -> sintomaDao.getAllGridByPerfil(tipoId, perfilId)).get();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<ItemGrid> getAllGridDiagnostico(Integer sintomaId, Integer perfilId) {
        try {
            return executorService.submit(() -> diagnosticoDao.getAllGrid(sintomaId, perfilId)).get();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
