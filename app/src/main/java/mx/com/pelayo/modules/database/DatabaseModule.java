package mx.com.pelayo.modules.database;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.pelayo.database.RoomDatabase;
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
import mx.com.pelayo.database.dao.security.SessionDao;
import mx.com.pelayo.database.dao.security.SyncDao;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.dao.ticket.TicketAddDao;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    RoomDatabase provideRoomDataBase(Application application) {
        RoomDatabase roomDatabase = RoomDatabase.getDatabase(application.getApplicationContext());
        return roomDatabase;
    }

    /*@Provides
    @Singleton
    public AccesoDao provideAccesoDao(RoomDatabase roomDatabase) {
        return roomDatabase.accesoDao();
    }*/

    @Provides
    @Singleton
    public CategoriaDao provideCategoriaDao(RoomDatabase roomDatabase) {
        return roomDatabase.categoriaDao();
    }

    @Provides
    @Singleton
    public DepartamentoDao provideDepartamentoDao(RoomDatabase roomDatabase) {
        return roomDatabase.departamentoDao();
    }

    @Provides
    @Singleton
    public DepartamentoSintomaDiagnosticoDao provideDepartamentoSintomaDiagnosticoDao(RoomDatabase roomDatabase) {
        return roomDatabase.departamentoSintomaDiagnosticoDao();
    }

    @Provides
    @Singleton
    public DepartamentoTipoSintomaDao provideDepartamentoTipoSintomaDao(RoomDatabase roomDatabase) {
        return roomDatabase.departamentoTipoSintomaDao();
    }

    @Provides
    @Singleton
    public DiagnosticoDao provideDiagnosticoDao(RoomDatabase roomDatabase) {
        return roomDatabase.diagnosticoDao();
    }

    @Provides
    @Singleton
    public DistritoDao provideDistritoDao(RoomDatabase roomDatabase) {
        return roomDatabase.distritoDao();
    }

    @Provides
    @Singleton
    public EstadoDao provideEstadoDao(RoomDatabase roomDatabase) {
        return roomDatabase.estadoDao();
    }

    @Provides
    @Singleton
    public IconDao provideIconDao(RoomDatabase roomDatabase) {
        return roomDatabase.iconDao();
    }

    @Provides
    @Singleton
    public IconEntityDao provideIconEntityDao(RoomDatabase roomDatabase) {
        return roomDatabase.iconEntityDao();
    }

    @Provides
    @Singleton
    public ImpCatMotivoDao provideImpCatMotivoDao(RoomDatabase roomDatabase) {
        return roomDatabase.impCatMotivoDao();
    }

    @Provides
    @Singleton
    public PerfilDao providePerfilDao(RoomDatabase roomDatabase) {
        return roomDatabase.perfilDao();
    }

    @Provides
    @Singleton
    public PerfilSintomaDiagnosticoDao providePerfilSintomaDiagnosticoDao(RoomDatabase roomDatabase) {
        return roomDatabase.perfilSintomaDiagnosticoDao();
    }

    @Provides
    @Singleton
    public PerfilTipoSintomaDao providePerfilTipoSintomaDao(RoomDatabase roomDatabase) {
        return roomDatabase.perfilTipoSintomaDao();
    }

    @Provides
    @Singleton
    public PosibleOrigenDao providePosibleOrigenDao(RoomDatabase roomDatabase) {
        return roomDatabase.posibleOrigenDao();
    }

    @Provides
    @Singleton
    public ProveedorDao provideProveedorDao(RoomDatabase roomDatabase) {
        return roomDatabase.proveedorDao();
    }

    @Provides
    @Singleton
    public PuestosDao providePuestosDao(RoomDatabase roomDatabase) {
        return roomDatabase.puestosDao();
    }

    @Provides
    @Singleton
    public RegionDao provideRegionDao(RoomDatabase roomDatabase) {
        return roomDatabase.regionDao();
    }

    @Provides
    @Singleton
    public SatUsuarioDao provideSatUsuarioDao(RoomDatabase roomDatabase) {
        return roomDatabase.satUsuarioDao();
    }

    @Provides
    @Singleton
    public SintomaDao provideSintomaDao(RoomDatabase roomDatabase) {
        return roomDatabase.sintomaDao();
    }

    @Provides
    @Singleton
    public SintomaDiagnosticoDao provideSintomaDiagnosticoDao(RoomDatabase roomDatabase) {
        return roomDatabase.sintomaDiagnosticoDao();
    }

    @Provides
    @Singleton
    public SolucionesStandardDao provideSolucionesStandardDao(RoomDatabase roomDatabase) {
        return roomDatabase.solucionesStandardDao();
    }

    @Provides
    @Singleton
    public StatusProyectosDao provideStatusProyectosDao(RoomDatabase roomDatabase) {
        return roomDatabase.statusProyectosDao();
    }

    @Provides
    @Singleton
    public SucursalDao provideSucursalDao(RoomDatabase roomDatabase) {
        return roomDatabase.sucursalDao();
    }

    @Provides
    @Singleton
    public TiendaDao provideTiendaDao(RoomDatabase roomDatabase) {
        return roomDatabase.tiendaDao();
    }

    @Provides
    @Singleton
    public TipoSintomaDao provideTipoSintomaDao(RoomDatabase roomDatabase) {
        return roomDatabase.tipoSintomaDao();
    }

    @Provides
    @Singleton
    public TipoSucursalDao provideTipoSucursalDao(RoomDatabase roomDatabase) {
        return roomDatabase.tipoSucursalDao();
    }

    @Provides
    @Singleton
    public TipotdDao provideTipotdDao(RoomDatabase roomDatabase) {
        return roomDatabase.tipotdDao();
    }

    @Provides
    @Singleton
    public UsuarioDao provideUsuarioDao(RoomDatabase roomDatabase) {
        return roomDatabase.usuarioDao();
    }

    @Provides
    @Singleton
    public ZonaDao provideZonaDao(RoomDatabase roomDatabase) {
        return roomDatabase.zonaDao();
    }

    @Provides
    @Singleton
    public SessionDao provideSessionDao(RoomDatabase roomDatabase) {
        return roomDatabase.sessionDao();
    }

    @Provides
    @Singleton
    public SyncDao provideSyncDao(RoomDatabase roomDatabase) {
        return roomDatabase.syncDao();
    }

    @Provides
    @Singleton
    public TicketAddDao provideTicketAddDao(RoomDatabase roomDatabase) {
        return roomDatabase.ticketAddDao();
    }


    @Provides
    @Singleton
    public UsuarioActualDao provideUsuarioActualDao(RoomDatabase roomDatabase) {
        return roomDatabase.usuarioActualDao();
    }

}
