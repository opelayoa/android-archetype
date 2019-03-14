package mx.com.pelayo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.TipoSucursal;
import mx.com.pelayo.database.entities.Tipotd;
import mx.com.pelayo.database.entities.custom.ItemGrid;

@Dao
public interface TipotdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Tipotd> tipotds);

    @Query("select tipotd.id, tipotd.nombre as descripcion, icon.unicode as icon \n" +
            "from tipotd\n" +
            "left join icon_entity on icon_entity.entity_id = tipotd.id and icon_entity.entity_type = 'type'\n" +
            "left join icon on icon.nombre = icon_entity.icon_name\n" +
            "where tipotd.id in (\n" +
            "\tselect distinct tipo_id from tipo_sintoma where id in (\n" +
            "\t\tselect distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId and status = 1))\n" +
            "and status = 1\n" +
            "order by descripcion")
    LiveData<List<ItemGrid>> getAllGridByPerfil(Integer perfilId);
}
