package mx.com.pelayo.database.dao.ticket;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.custom.ItemAutocomplete;

@Dao
public interface TicketAddDao {


    @Query("select id, apellido || ', ' || nombre as label from usuario")
    LiveData<List<ItemAutocomplete>> getAllUsuarios();

    @Query("select rclave as id , rclave || ' - ' || rdesc as label from region")
    LiveData<List<ItemAutocomplete>> getAllRegions();
}
