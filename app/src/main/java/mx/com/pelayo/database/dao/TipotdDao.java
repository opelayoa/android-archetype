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

    @Query("select tipotd.id, tipotd.nombre as descripcion, icon.unicode as icon from tipotd , icon, icon_entity \n" +
            "where tipotd.id in (\n" +
            "   select distinct tipo_id from tipo_sintoma where id in (\n" +
            "       select distinct ts_id from perfil_tipo_sintoma where perfil_id = :perfilId)\n" +
            "\t) \n" +
            "and icon_entity.entity_type = 'type' \n" +
            "and icon_entity.entity_id = tipotd.id\n" +
            "and icon_entity.icon_name = icon.nombre\n" +
            "order by tipotd.nombre")
    LiveData<List<ItemGrid>> getAllGridByPerfil(Integer perfilId);
}
