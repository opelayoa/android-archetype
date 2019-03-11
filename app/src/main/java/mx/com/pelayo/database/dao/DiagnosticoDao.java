package mx.com.pelayo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Diagnostico;
import mx.com.pelayo.database.entities.Distrito;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Dao
public interface DiagnosticoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Diagnostico> diagnosticos);

    @Query("select id as id, descripcion, '\ue90d' as icon from diagnostico where id in (" +
            "select distinct diagnostico_id from sintoma_diagnostico where sintoma_id = :sintomaId and id in (" +
            "select distinct sd_id from perfil_sintoma_diagnostico where perfil_id = :perfilId" +
            ")" +
            ")"
    )
    LiveData<List<ItemGrid>> getAllGrid(Integer sintomaId, Integer perfilId);
}
