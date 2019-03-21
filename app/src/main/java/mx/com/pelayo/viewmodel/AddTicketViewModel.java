package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;
import mx.com.pelayo.database.entities.custom.UsuarioInfo;
import mx.com.pelayo.database.entities.security.UsuarioActual;
import mx.com.pelayo.repository.SecurityRepository;
import mx.com.pelayo.repository.TicketAddRepository;

@Singleton
public class AddTicketViewModel extends ViewModel {

    private TicketAddRepository ticketAddRepository;
    private SecurityRepository securityRepository;

    private LiveData<List<ItemAutocomplete>> regions;
    private LiveData<List<Usuario>> users;
    private LiveData<List<ItemAutocomplete>> technicians;
    private LiveData<List<ItemAutocomplete>> districts;
    private LiveData<List<ItemAutocomplete>> stores;
    private LiveData<List<ItemAutocomplete>> departments;

    private MutableLiveData<Integer> filterRegion = new MutableLiveData<>();

    private MutableLiveData<Integer> filterDisctrict = new MutableLiveData<>();
    private MutableLiveData<ExpertParams> expertParams = new MutableLiveData<>();

    @Inject
    public AddTicketViewModel(TicketAddRepository ticketAddRepository, SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
        this.ticketAddRepository = ticketAddRepository;
        this.regions = ticketAddRepository.getAllRegions();
        this.users = Transformations.switchMap(filterRegion, ticketAddRepository::getAllUsuarios);
        this.technicians = Transformations.switchMap(expertParams, technicalParams -> {
            if (technicalParams.getDepartmentId() == 3) {
                return ticketAddRepository.getAllTechnicianByDepartment(technicalParams.getDepartmentId());
            } else {
                return ticketAddRepository.getAllTechnicianByRegion(technicalParams.getRegionId());
            }
        });
        this.districts = Transformations.switchMap(filterRegion, ticketAddRepository::getAllDistritosByRegion);
        this.stores = Transformations.switchMap(filterDisctrict, ticketAddRepository::getAllTiendasByDistrito);
        this.departments = ticketAddRepository.getAllDepartments();
    }

    public LiveData<List<ItemAutocomplete>> getStores() {
        return stores;
    }

    public LiveData<List<ItemAutocomplete>> getRegions() {
        return regions;
    }

    public LiveData<List<Usuario>> getUsers() {
        return users;
    }

    public LiveData<List<ItemAutocomplete>> getExperts() {
        return technicians;
    }

    public LiveData<List<ItemAutocomplete>> getDistricts() {
        return districts;
    }

    public LiveData<List<ItemAutocomplete>> getDepartments() {
        return departments;
    }

    public void setFilterRegion(Integer regionId) {
        this.filterRegion.setValue(regionId);
    }

    public void setFilterDisctrict(Integer distritoId) {
        this.filterDisctrict.setValue(distritoId);
    }

    public void setExpertParams(ExpertParams expertParams) {
        this.expertParams.setValue(expertParams);
    }

    public UsuarioActual getUsuarioActual() {
        return securityRepository.getUsuarioActualSynchronous();
    }

    public UsuarioInfo getUsuarioInfo() {
        return securityRepository.getUsuarioInfo();
    }

    public static class ExpertParams {

        private Integer departmentId;
        private Integer regionId;

        public ExpertParams(Integer departmentId, Integer regionId) {
            this.departmentId = departmentId;
            this.regionId = regionId;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getRegionId() {
            return regionId;
        }

        public void setRegionId(Integer regionId) {
            this.regionId = regionId;
        }
    }
}
