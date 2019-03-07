package mx.com.pelayo.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import mx.com.pelayo.database.entities.PosibleOrigen;
import mx.com.pelayo.database.entities.Region;

@Dao
public interface PosibleOrigenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<PosibleOrigen> posibleOrigenes);
}
