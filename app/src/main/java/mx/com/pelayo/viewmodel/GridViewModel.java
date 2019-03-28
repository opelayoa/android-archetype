package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.repository.GridRepository;
import mx.com.pelayo.repository.SecurityRepository;

@Singleton
public class GridViewModel extends ViewModel {

    private GridRepository gridRepository;
    private SecurityRepository securityRepository;

    private MutableLiveData<Integer> profileFilter = new MutableLiveData<>();
    private MutableLiveData<SymptomFilter> symptomFilter = new MutableLiveData<>();
    private MutableLiveData<DiagnosticFilter> diagnosticFilter = new MutableLiveData<>();
    private LiveData<List<ItemGrid>> types;
    private LiveData<List<ItemGrid>> symptoms;
    private LiveData<List<ItemGrid>> diagnostics;
    private LiveData<List<ItemGrid>> ticketStates;
    private LiveData<UserInformation> userInformation;

    @Inject
    public GridViewModel(GridRepository gridRepository, SecurityRepository securityRepository) {
        this.gridRepository = gridRepository;
        this.securityRepository = securityRepository;
        this.types = Transformations.switchMap(profileFilter, gridRepository::getAllGridTipo);
        this.symptoms = Transformations.switchMap(symptomFilter, symptomParams -> gridRepository.getAllGridSintoma(symptomParams.getTypeId(), symptomParams.getProfileId()));
        this.diagnostics = Transformations.switchMap(diagnosticFilter, diagnosticParams -> gridRepository.getAllGridDiagnostico(diagnosticParams.getSymptomId(), diagnosticParams.getProfileId()));
        this.userInformation = this.securityRepository.getUserInformation();
        this.ticketStates = this.gridRepository.getAllGridTicketStates();
    }

    public LiveData<List<ItemGrid>> getTypes() {
        return this.types;
    }

    public LiveData<List<ItemGrid>> getSymptoms() {
        return this.symptoms;
    }

    public LiveData<List<ItemGrid>> getDiagnostics() {
        return this.diagnostics;
    }

    public LiveData<UserInformation> getUserInformation() {
        return this.userInformation;
    }

    public LiveData<List<ItemGrid>> getTicketStates() {
        return ticketStates;
    }

    public void setSymptomFilter(SymptomFilter symptomFilter) {
        this.symptomFilter.setValue(symptomFilter);
    }

    public void setDiagnosticFilter(DiagnosticFilter diagnosticFilter) {
        this.diagnosticFilter.setValue(diagnosticFilter);
    }

    public void setProfileFilter(Integer profileId) {
        this.profileFilter.setValue(profileId);
    }

    public static class SymptomFilter {
        private Integer typeId;
        private Integer profileId;

        public SymptomFilter(Integer typeId, Integer profileId) {
            this.typeId = typeId;
            this.profileId = profileId;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public Integer getProfileId() {
            return profileId;
        }

        public void setProfileId(Integer profileId) {
            this.profileId = profileId;
        }
    }

    public static class DiagnosticFilter {
        private Integer symptomId;
        private Integer profileId;

        public DiagnosticFilter(Integer symptomId, Integer profileId) {
            this.symptomId = symptomId;
            this.profileId = profileId;
        }

        public Integer getSymptomId() {
            return symptomId;
        }

        public void setSymptomId(Integer symptomId) {
            this.symptomId = symptomId;
        }

        public Integer getProfileId() {
            return profileId;
        }

        public void setProfileId(Integer profileId) {
            this.profileId = profileId;
        }
    }
}
