package mx.com.pelayo.database.dao.security;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import mx.com.pelayo.database.entities.security.Session;
import mx.com.pelayo.database.entities.security.Sync;

@Dao
public interface SyncDao {

    @Insert
    Long insert(Sync sync);

    @Query("select * from synchronization where user_id = :userId")
    Sync getSyncByUserId(Integer userId);

    @Query("delete from synchronization")
    void deleteAll();
}
