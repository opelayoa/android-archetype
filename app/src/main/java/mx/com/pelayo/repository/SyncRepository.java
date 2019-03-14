package mx.com.pelayo.repository;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.TdeService;
import mx.com.pelayo.database.dao.CategoriaDao;
import mx.com.pelayo.database.dao.DepartamentoDao;
import mx.com.pelayo.database.dao.DepartamentoSintomaDiagnosticoDao;
import mx.com.pelayo.database.dao.DepartamentoTipoSintomaDao;
import mx.com.pelayo.database.dao.DiagnosticoDao;
import mx.com.pelayo.database.dao.DistritoDao;
import mx.com.pelayo.database.dao.EstadoDao;
import mx.com.pelayo.database.dao.IconDao;
import mx.com.pelayo.database.dao.IconEntityDao;
import mx.com.pelayo.database.dao.ImpCatMotivoDao;
import mx.com.pelayo.database.dao.PerfilDao;
import mx.com.pelayo.database.dao.PerfilSintomaDiagnosticoDao;
import mx.com.pelayo.database.dao.PerfilTipoSintomaDao;
import mx.com.pelayo.database.dao.PosibleOrigenDao;
import mx.com.pelayo.database.dao.ProveedorDao;
import mx.com.pelayo.database.dao.PuestosDao;
import mx.com.pelayo.database.dao.RegionDao;
import mx.com.pelayo.database.dao.SatUsuarioDao;
import mx.com.pelayo.database.dao.SintomaDao;
import mx.com.pelayo.database.dao.SintomaDiagnosticoDao;
import mx.com.pelayo.database.dao.SolucionesStandardDao;
import mx.com.pelayo.database.dao.StatusProyectosDao;
import mx.com.pelayo.database.dao.SucursalDao;
import mx.com.pelayo.database.dao.TiendaDao;
import mx.com.pelayo.database.dao.TipoSintomaDao;
import mx.com.pelayo.database.dao.TipoSucursalDao;
import mx.com.pelayo.database.dao.TipotdDao;
import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.dao.ZonaDao;
import mx.com.pelayo.database.dao.security.SyncDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.security.Sync;

@Singleton
public class SyncRepository {

    public TdeService tdeService;
    // private AccesoDao accesoDao;
    private CategoriaDao categoriaDao;
    private DepartamentoDao departamentoDao;
    private DepartamentoSintomaDiagnosticoDao departamentoSintomaDiagnosticoDao;
    private DepartamentoTipoSintomaDao departamentoTipoSintomaDao;
    private DiagnosticoDao diagnosticoDao;
    private DistritoDao distritoDao;
    private EstadoDao estadoDao;
    private IconDao iconDao;
    private IconEntityDao iconEntityDao;
    private ImpCatMotivoDao impCatMotivoDao;
    private PerfilDao perfilDao;
    private PerfilSintomaDiagnosticoDao perfilSintomaDiagnosticoDao;
    private PerfilTipoSintomaDao perfilTipoSintomaDao;
    private PosibleOrigenDao posibleOrigenDao;
    private ProveedorDao proveedorDao;
    private PuestosDao puestosDao;
    private RegionDao regionDao;
    private SatUsuarioDao satUsuarioDao;
    private SintomaDao sintomaDao;
    private SintomaDiagnosticoDao sintomaDiagnosticoDao;
    private SolucionesStandardDao solucionesStandardDao;
    private StatusProyectosDao statusProyectosDao;
    private SucursalDao sucursalDao;
    private TiendaDao tiendaDao;
    private TipoSintomaDao tipoSintomaDao;
    private TipoSucursalDao tipoSucursalDao;
    private TipotdDao tipotdDao;
    private UsuarioDao usuarioDao;
    private ZonaDao zonaDao;
    private SyncDao syncDao;
    private UsuarioActualDao usuarioActualDao;

    @Inject
    public SyncRepository(/*AccesoDao accesoDao, */CategoriaDao categoriaDao, DepartamentoDao departamentoDao,
                                                   DepartamentoSintomaDiagnosticoDao departamentoSintomaDiagnosticoDao, DepartamentoTipoSintomaDao departamentoTipoSintomaDao,
                                                   DiagnosticoDao diagnosticoDao, DistritoDao distritoDao, EstadoDao estadoDao, IconDao iconDao, IconEntityDao iconEntityDao, ImpCatMotivoDao impCatMotivoDao,
                                                   PerfilDao perfilDao, PerfilSintomaDiagnosticoDao perfilSintomaDiagnosticoDao, PerfilTipoSintomaDao perfilTipoSintomaDao,
                                                   PosibleOrigenDao posibleOrigenDao, ProveedorDao proveedorDao, PuestosDao puestosDao, RegionDao regionDao, SatUsuarioDao satUsuarioDao,
                                                   SintomaDao sintomaDao, SintomaDiagnosticoDao sintomaDiagnosticoDao, SolucionesStandardDao solucionesStandardDao, StatusProyectosDao statusProyectosDao,
                                                   SucursalDao sucursalDao, TiendaDao tiendaDao, TipoSintomaDao tipoSintomaDao, TipoSucursalDao tipoSucursalDao, TipotdDao tipotdDao,
                                                   UsuarioDao usuarioDao, ZonaDao zonaDao, TdeService tdeService, SyncDao syncDao, UsuarioActualDao usuarioActualDao) {
        // this.accesoDao = accesoDao;
        this.categoriaDao = categoriaDao;
        this.departamentoDao = departamentoDao;
        this.departamentoSintomaDiagnosticoDao = departamentoSintomaDiagnosticoDao;
        this.departamentoTipoSintomaDao = departamentoTipoSintomaDao;
        this.diagnosticoDao = diagnosticoDao;
        this.distritoDao = distritoDao;
        this.estadoDao = estadoDao;
        this.iconDao = iconDao;
        this.iconEntityDao = iconEntityDao;
        this.impCatMotivoDao = impCatMotivoDao;
        this.perfilDao = perfilDao;
        this.perfilSintomaDiagnosticoDao = perfilSintomaDiagnosticoDao;
        this.perfilTipoSintomaDao = perfilTipoSintomaDao;
        this.posibleOrigenDao = posibleOrigenDao;
        this.proveedorDao = proveedorDao;
        this.puestosDao = puestosDao;
        this.regionDao = regionDao;
        this.satUsuarioDao = satUsuarioDao;
        this.sintomaDao = sintomaDao;
        this.sintomaDiagnosticoDao = sintomaDiagnosticoDao;
        this.solucionesStandardDao = solucionesStandardDao;
        this.statusProyectosDao = statusProyectosDao;
        this.sucursalDao = sucursalDao;
        this.tiendaDao = tiendaDao;
        this.tipoSintomaDao = tipoSintomaDao;
        this.tipoSucursalDao = tipoSucursalDao;
        this.tipotdDao = tipotdDao;
        this.usuarioDao = usuarioDao;
        this.zonaDao = zonaDao;
        this.syncDao = syncDao;
        this.usuarioActualDao = usuarioActualDao;
        this.tdeService = tdeService;
    }

    public Observable sync() {
        return this.tdeService.getAllSatUsuarios()
                .map(satUsuarios -> satUsuarioDao.insertAll(satUsuarios))
                .flatMap(data -> tdeService.getAllEstados())
                .map(estados -> estadoDao.insertAll(estados))
                .flatMap(data -> tdeService.getAllUsuarios())
                .map(usuarios -> usuarioDao.insertAll(usuarios))
                .flatMap(data -> tdeService.getAllUsuarios())
                .map(usuarios -> usuarioDao.insertAll(usuarios))
                .flatMap(data -> tdeService.getAllCategorias())
                .map(categorias -> categoriaDao.insertAll(categorias))
                .flatMap(data -> tdeService.getAllTipotds())
                .map(tipos -> tipotdDao.insertAll(tipos))
                .flatMap(data -> tdeService.getAllStatusProyectos())
                .map(statusProyectosList -> statusProyectosDao.insertAll(statusProyectosList))
                .flatMap(data -> tdeService.getAllSintomas())
                .map(sintomas -> sintomaDao.insertAll(sintomas))
                .flatMap(data -> tdeService.getAllDiagnosticos())
                .map(diagnosticos -> diagnosticoDao.insertAll(diagnosticos))
                .flatMap(data -> tdeService.getAllTipoSintoma())
                .map(tipoSintomaList -> tipoSintomaDao.insertAll(tipoSintomaList))
                .flatMap(data -> tdeService.getAllSintoDiagnostico())
                .map(sintomaDiagnosticoList -> sintomaDiagnosticoDao.insertAll(sintomaDiagnosticoList))
                .flatMap(data -> tdeService.getAllImpCatMotivo())
                .map(impCatMotivoList -> impCatMotivoDao.insertAll(impCatMotivoList))
                .flatMap(data -> tdeService.getAllTipoSucursal())
                .map(tipoSucursalList -> tipoSucursalDao.insertAll(tipoSucursalList))
                .flatMap(data -> tdeService.getAllSucursales())
                .map(sucursales -> sucursalDao.insertAll(sucursales))
                .flatMap(data -> tdeService.getAllSolucionesStandard())
                .map(solucionesStandardList -> solucionesStandardDao.insertAll(solucionesStandardList))
                .flatMap(data -> tdeService.getAllPosibleOrigen())
                .map(posibleOrigenList -> posibleOrigenDao.insertAll(posibleOrigenList))
                .flatMap(data -> tdeService.getAllProveedores())
                .map(proveedores -> proveedorDao.insertAll(proveedores))
                .flatMap(data -> tdeService.getAllPerfiles())
                .map(perfiles -> perfilDao.insertAll(perfiles))
                .flatMap(data -> tdeService.getAllPerfiles())
                .map(perfiles -> perfilDao.insertAll(perfiles))
                // TODO: Ver que pasa con la tabla de Accesos
                .flatMap(data -> tdeService.getAllPerfilTipoSintoma())
                .map(perfilTipoSintomaList -> perfilTipoSintomaDao.insertAll(perfilTipoSintomaList))
                .flatMap(data -> tdeService.getAllPerfilSintomaDiagnostico())
                .map(perfilSintomaDiagnosticoList -> perfilSintomaDiagnosticoDao.insertAll(perfilSintomaDiagnosticoList))
                .flatMap(data -> tdeService.getAllDepartamentos())
                .map(departamentos -> departamentoDao.insertAll(departamentos))
                .flatMap(data -> tdeService.getAllPuestos())
                .map(puestosList -> puestosDao.insertAll(puestosList))
                .flatMap(data -> tdeService.getAllRegiones())
                .map(regiones -> regionDao.insertAll(regiones))
                .flatMap(data -> tdeService.getAllDistritos())
                .map(distritos -> distritoDao.insertAll(distritos))
                .flatMap(data -> tdeService.getAllTiendas())
                .map(tiendas -> tiendaDao.insertAll(tiendas))
                .flatMap(data -> tdeService.getAllZona())
                .map(zonas -> zonaDao.insertAll(zonas))
                .flatMap(data -> tdeService.getAllDepartamentoTipoSintoma())
                .map(departamentoTipoSintomaList -> departamentoTipoSintomaDao.insertAll(departamentoTipoSintomaList))
                .flatMap(data -> tdeService.getAllDepartamentoSintomaDiagnostico())
                .map(departamentoSintomaDiagnosticoList -> departamentoSintomaDiagnosticoDao.insertAll(departamentoSintomaDiagnosticoList))
                .flatMap(data -> tdeService.getAllIcons())
                .map(icons -> iconDao.insertAll(icons))
                .flatMap(data -> tdeService.getAllIconEntities())
                .map(iconEntities -> iconEntityDao.insertAll(iconEntities))
                .map(data -> {
                    syncDao.deleteAll();
                    UsuarioActualComposed usuarioActualComposed = usuarioActualDao.getUserUsuarioActual();
                    Sync sync = new Sync();
                    sync.setDate(new Date());
                    sync.setStatus(1);
                    sync.setUserId(usuarioActualComposed.usuarioActual.getId());
                    long id = syncDao.insert(sync);
                    return 1;
                })
                .onErrorResumeNext(observer -> {
                    syncDao.deleteAll();
                    UsuarioActualComposed usuarioActualComposed = usuarioActualDao.getUserUsuarioActual();
                    Sync sync = new Sync();
                    sync.setStatus(2);
                    syncDao.insert(sync);
                })
                ;

    }
}
