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

    @Query("select sintoma.id as id, sintoma.nombre as descripcion, icon.unicode as icon \n" +
            "from sintoma \n" +
            "left join icon_entity on icon_entity.entity_id = sintoma.id and icon_entity.entity_type = 'symptom'\n" +
            "left join icon on icon.nombre = icon_entity.icon_name\n" +
            "where sintoma.id in (select distinct sintoma_id  from tipo_sintoma where tipo_id = :tipoId and id in (select distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId and status = 1) and status = 1) \n" +
            "and sintoma.status = 'Activo' \n" +
            "order by sintoma.nombre")
    LiveData<List<ItemGrid>> getAllGridByPerfil(Integer tipoId, Integer perfilId);
}
