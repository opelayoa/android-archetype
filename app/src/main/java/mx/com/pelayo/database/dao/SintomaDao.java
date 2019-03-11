package mx.com.pelayo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Sintoma;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Dao
public interface SintomaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Sintoma> sintomas);

    @Query("select id as id, nombre as descripcion, '\ue90d' as icon from sintoma where id in (select distinct sintoma_id  from tipo_sintoma where tipo_id = :tipoId and id in (select distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId)) order by nombre")
    LiveData<List<ItemGrid>> getAllGridByPerfil(Integer tipoId, Integer perfilId);
}
