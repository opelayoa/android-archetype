package mx.com.pelayo.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import mx.com.pelayo.database.entities.SintomaDiagnostico;

@Dao
public interface SintomaDiagnosticoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<SintomaDiagnostico> sintomaDiagnosticos);
}
