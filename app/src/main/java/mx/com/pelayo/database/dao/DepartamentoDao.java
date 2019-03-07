package mx.com.pelayo.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import mx.com.pelayo.database.entities.Categoria;
import mx.com.pelayo.database.entities.Departamento;

@Dao
public interface DepartamentoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Departamento> departamentos);
}
