package mx.com.pelayo.database.dao.security;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Tipotd;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.security.Session;
import mx.com.pelayo.database.entities.security.UsuarioActual;

@Dao
public interface UsuarioActualDao {

    @Query("delete from usuario_actual")
    void deleteAll();

    @Insert
    Long insert(UsuarioActual usuarioActual);

    @Query("select * from usuario_actual")
    LiveData<UsuarioActualComposed> getUserUsuarioActualLiveData();

    @Query("select * from usuario_actual")
    UsuarioActualComposed getUserUsuarioActual();

    @Query("select * from tipotd where id in (select distinct id from tipo_sintoma where id in (select distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId)) order by nombre")
    LiveData<List<Tipotd>> getAllByPerfil(Integer perfilId);
}
