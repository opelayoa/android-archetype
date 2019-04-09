package mx.com.pelayo.database.dao.security;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Tipotd;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.database.entities.security.UsuarioActual;

@Dao
public interface UsuarioActualDao {

    @Query("delete from usuario_actual")
    void deleteAll();

    @Insert
    Long insert(UsuarioActual usuarioActual);

    @Query("select * from usuario_actual")
    LiveData<UsuarioActualComposed> getUsuarioActualLiveData();

    @Query("select * from usuario_actual")
    UsuarioActual getUsuarioActual();

    @Query("select usuario.id, usuario.apellido, usuario.nombre, usuario.email, sucursal.id as sucusalId, \n" +
            "       almacen.id as almacenId, almacen.nombre as almacenDesc, almacen.numero3b as numero3b,   \n" +
            "       sucursal.nombre as sucursalDesc, region.rclave as regionId, region.rdesc as regionDesc, \n" +
            "       perfil.id as perfilId, perfil.nombre as perfilDesc, puestos.id as puestoId,\n" +
            "       puestos.nombre as puestoDesc, departamento.id as departamentoId, departamento.nombre as departamentoDesc\n" +
            "from usuario_actual usuario \n" +
            "left join sucursal on usuario.sucursal_id = sucursal.id\n" +
            "left join sucursal almacen on sucursal.almacen_id = almacen.id\n" +
            "left join region on almacen.numero3b = region.rclave\n" +
            "left join perfil on usuario.perfil_id = perfil.id\n" +
            "left join puestos on usuario.puesto_id = puestos.id\n" +
            "left join departamento on usuario.departamento_id = departamento.id")
    UserInformation getUsuarioInfo();

    @Query("select usuario.id, usuario.apellido, usuario.nombre, usuario.email, sucursal.id as sucusalId, \n" +
            "       almacen.id as almacenId, almacen.nombre as almacenDesc, almacen.numero3b as numero3b,   \n" +
            "       sucursal.nombre as sucursalDesc, region.rclave as regionId, region.rdesc as regionDesc, \n" +
            "       perfil.id as perfilId, perfil.nombre as perfilDesc, puestos.id as puestoId,\n" +
            "       puestos.nombre as puestoDesc, departamento.id as departamentoId, departamento.nombre as departamentoDesc\n" +
            "from usuario_actual usuario \n" +
            "left join sucursal on usuario.sucursal_id = sucursal.id\n" +
            "left join sucursal almacen on sucursal.almacen_id = almacen.id\n" +
            "left join region on almacen.numero3b = region.rclave\n" +
            "left join perfil on usuario.perfil_id = perfil.id\n" +
            "left join puestos on usuario.puesto_id = puestos.id\n" +
            "left join departamento on usuario.departamento_id = departamento.id")
    LiveData<UserInformation> getUserInfo();

    @Query("select * from tipotd where id in (select distinct id from tipo_sintoma where id in (select distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId)) order by nombre")
    LiveData<List<Tipotd>> getAllByPerfil(Integer perfilId);
}
