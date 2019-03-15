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

    @Query("select diagnostico.id as id, diagnostico.descripcion as descripcion, icon.unicode as icon  \n" +
            "from diagnostico\n" +
            "left join icon_entity on icon_entity.entity_id = diagnostico.id and icon_entity.entity_type = 'diagnostic'\n" +
            "left join icon on icon.nombre = icon_entity.icon_name\n" +
            "where diagnostico.id in (select distinct diagnostico_id  from sintoma_diagnostico where sintoma_id = :sintomaId and id in (select distinct sd_id from perfil_sintoma_diagnostico where perfil_id = :perfilId and status = 1) and status = 1) \n" +
            "and diagnostico.status = 'Activo' \n" +
            "order by diagnostico.descripcion")
    List<ItemGrid> getAllGrid(Integer sintomaId, Integer perfilId);
}
