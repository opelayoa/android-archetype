package mx.com.pelayo.database.dao.security;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Observable;

import mx.com.pelayo.database.entities.security.Session;

@Dao
public interface SessionDao {

    @Query("delete from session")
    void deleteAll();

    @Insert
    Long insert(Session session);
}
