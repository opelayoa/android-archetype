package mx.com.pelayo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Estado;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Dao
public interface EstadoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Estado> estados);

    @Query("select estado.id, estado.nombre as descripcion, icon.unicode as icon\n" +
            "from estado\n" +
            "left join icon_entity ie on estado.id = ie.entity_id and ie.entity_type = 'ticket_state'\n" +
            "left join icon on ie.icon_name = icon.nombre\n" +
            "where estado.oculto <> 1\n" +
            "order by estado.id;")
    LiveData<List<ItemGrid>> getAllTicketStates();
}
