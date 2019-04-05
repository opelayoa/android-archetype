package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.TdeService;
import mx.com.pelayo.api.entities.TicketInfo;

@Singleton
public class DetailTicketViewModel extends ViewModel {

    private TdeService tdeService;

    @Inject
    public DetailTicketViewModel(TdeService tdeService) {
        this.tdeService = tdeService;

    }

    public Observable<TicketInfo> getTicketDetail(Integer ticketId) {
        return tdeService.getTicketInfo(ticketId);
    }

}
