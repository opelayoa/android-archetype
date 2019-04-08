package mx.com.pelayo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.dao.ticket.TicketAddDao;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;

@Singleton
public class TicketAddRepository {

    private TicketAddDao ticketAddDao;

    @Inject
    public TicketAddRepository(TicketAddDao ticketAddDao) {
        this.ticketAddDao = ticketAddDao;
    }

    public LiveData<List<Usuario>> getAllUsuarios(Integer regionId) {
        return ticketAddDao.getAllUsuarios(regionId);
    }

    public LiveData<List<ItemAutocomplete>> getAllRegions() {
        return ticketAddDao.getAllRegions();
    }

    public LiveData<List<ItemAutocomplete>> getAllTechnicianByRegion(Integer regionId) {
        return ticketAddDao.getAllTechnicianByRegion(regionId);
    }

    public LiveData<List<ItemAutocomplete>> getAllTechnicianByDepartment(Integer departmentId) {
        return ticketAddDao.getAllTechnicianByDepartment(departmentId);
    }

    public LiveData<List<ItemAutocomplete>> getAllDistritosByRegion(Integer regionId) {
        return ticketAddDao.getAllDistritosByRegion(regionId);
    }

    public LiveData<List<ItemAutocomplete>> getAllTiendasByDistrito(Integer distritoId) {
        return ticketAddDao.getAllTiendasByDistrito(distritoId);
    }

    public LiveData<List<ItemAutocomplete>> getAllDepartments() {
        return ticketAddDao.getAllDepartments();
    }

    public LiveData<List<ItemAutocomplete>> getAllUsuariosByDepartment(Integer departmentId) {
        return ticketAddDao.getAllUsuariosByDepartment(departmentId);
    }

    public LiveData<ItemAutocomplete> getDiagnosticById(Integer diagnosticId) {
        return ticketAddDao.getDiagnosticById(diagnosticId);
    }

    public Integer getTypeSymptomId (Integer typeId, Integer symptomId) {
        return ticketAddDao.getTipoSintomaId(typeId, symptomId);
    }

    public String getTypeSymptomName (Integer typeId, Integer symptomId) {
        return ticketAddDao.getTipoSintomaName(typeId, symptomId);
    }

    public Integer getSymptomDiagnosticId(Integer symptomId, Integer diagnosticId) {
        return  ticketAddDao.getSintomaDiagnosticoId(symptomId, diagnosticId);
    }

    public String getSymptomDiagnosticName(Integer symptomId, Integer diagnosticId) {
        return  ticketAddDao.getSintomaDiagnosticoName(symptomId, diagnosticId);
    }
}
