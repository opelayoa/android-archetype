package mx.com.pelayo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Usuario;

@Dao
public interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<Usuario> usuarios);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Usuario usuario);

    @Query("select * from usuario order by id asc")
    LiveData<List<Usuario>> getAll();
}
