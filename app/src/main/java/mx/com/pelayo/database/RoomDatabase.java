package mx.com.pelayo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import mx.com.pelayo.database.dao.CategoriaDao;
import mx.com.pelayo.database.dao.DepartamentoDao;
import mx.com.pelayo.database.dao.DepartamentoSintomaDiagnosticoDao;
import mx.com.pelayo.database.dao.DepartamentoTipoSintomaDao;
import mx.com.pelayo.database.dao.DiagnosticoDao;
import mx.com.pelayo.database.dao.DistritoDao;
import mx.com.pelayo.database.dao.EstadoDao;
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
import mx.com.pelayo.database.entities.Categoria;
import mx.com.pelayo.database.entities.Departamento;
import mx.com.pelayo.database.entities.DeptoSintomaDiagnostico;
import mx.com.pelayo.database.entities.DeptoTipoSintoma;
import mx.com.pelayo.database.entities.Diagnostico;
import mx.com.pelayo.database.entities.Distrito;
import mx.com.pelayo.database.entities.Estado;
import mx.com.pelayo.database.entities.ImpCatMotivo;
import mx.com.pelayo.database.entities.Perfil;
import mx.com.pelayo.database.entities.PerfilSintomaDiagnostico;
import mx.com.pelayo.database.entities.PerfilTipoSintoma;
import mx.com.pelayo.database.entities.PosibleOrigen;
import mx.com.pelayo.database.entities.Proveedor;
import mx.com.pelayo.database.entities.Puestos;
import mx.com.pelayo.database.entities.Region;
import mx.com.pelayo.database.entities.SatUsuario;
import mx.com.pelayo.database.entities.Sintoma;
import mx.com.pelayo.database.entities.SintomaDiagnostico;
import mx.com.pelayo.database.entities.SolucionesStandard;
import mx.com.pelayo.database.entities.StatusProyectos;
import mx.com.pelayo.database.entities.Sucursal;
import mx.com.pelayo.database.entities.Tienda;
import mx.com.pelayo.database.entities.TipoSintoma;
import mx.com.pelayo.database.entities.TipoSucursal;
import mx.com.pelayo.database.entities.Tipotd;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.Zona;
import mx.com.pelayo.database.entities.security.Session;

@Database(entities = {
        // Acceso.class,
        Categoria.class,
        Departamento.class,
        DeptoSintomaDiagnostico.class,
        DeptoTipoSintoma.class,
        Diagnostico.class,
        Distrito.class,
        Estado.class,
        ImpCatMotivo.class,
        Perfil.class,
        PerfilSintomaDiagnostico.class,
        PerfilTipoSintoma.class,
        PosibleOrigen.class,
        Proveedor.class,
        Puestos.class,
        Region.class,
        SatUsuario.class,
        Sintoma.class,
        SintomaDiagnostico.class,
        SolucionesStandard.class,
        StatusProyectos.class,
        Sucursal.class,
        Tienda.class,
        TipoSintoma.class,
        TipoSucursal.class,
        Tipotd.class,
        Usuario.class,
        Zona.class,
        // Security
        Session.class
}
        , exportSchema = false
        , version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {

    private static volatile RoomDatabase INSTANCE;
    // public abstract AccesoDao accesoDao();

    public static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract CategoriaDao categoriaDao();

    public abstract DepartamentoDao departamentoDao();

    public abstract DepartamentoSintomaDiagnosticoDao departamentoSintomaDiagnosticoDao();

    public abstract DepartamentoTipoSintomaDao departamentoTipoSintomaDao();

    public abstract DiagnosticoDao diagnosticoDao();

    public abstract DistritoDao distritoDao();

    public abstract EstadoDao estadoDao();

    public abstract ImpCatMotivoDao impCatMotivoDao();

    public abstract PerfilDao perfilDao();

    public abstract PerfilSintomaDiagnosticoDao perfilSintomaDiagnosticoDao();

    public abstract PerfilTipoSintomaDao perfilTipoSintomaDao();

    public abstract PosibleOrigenDao posibleOrigenDao();

    public abstract ProveedorDao proveedorDao();

    public abstract PuestosDao puestosDao();

    public abstract RegionDao regionDao();

    public abstract SatUsuarioDao satUsuarioDao();

    public abstract SintomaDao sintomaDao();

    public abstract SintomaDiagnosticoDao sintomaDiagnosticoDao();

    public abstract SolucionesStandardDao solucionesStandardDao();

    public abstract StatusProyectosDao statusProyectosDao();

    public abstract SucursalDao sucursalDao();

    public abstract TiendaDao tiendaDao();

    public abstract TipoSintomaDao tipoSintomaDao();

    public abstract TipoSucursalDao tipoSucursalDao();

    public abstract TipotdDao tipotdDao();

    public abstract UsuarioDao usuarioDao();

    public abstract SessionDao sessionDao();

    // Security
    public abstract ZonaDao zonaDao();
}
