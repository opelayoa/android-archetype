package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.dao.ticket.TicketAddDao;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;

@Singleton
public class TicketAddRepository {

    private TicketAddDao ticketAddDao;

    @Inject
    public TicketAddRepository(TicketAddDao ticketAddDao) {
        this.ticketAddDao = ticketAddDao;
    }

    public LiveData<List<ItemAutocomplete>> getAllUsuarios() {
        return ticketAddDao.getAllUsuarios();
    }

    public LiveData<List<ItemAutocomplete>> getAllRegions() {
        return ticketAddDao.getAllRegions();
    }
}
