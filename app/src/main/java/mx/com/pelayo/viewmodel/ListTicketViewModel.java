package mx.com.pelayo.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import mx.com.pelayo.api.entities.TicketInfo;
import mx.com.pelayo.api.entities.TicketSummary;
import mx.com.pelayo.repository.TicketListRepository;

@Singleton
public class ListTicketViewModel extends ViewModel {

    private TicketListRepository ticketListRepository;

    @Inject
    public ListTicketViewModel(TicketListRepository ticketListRepository) {
        this.ticketListRepository = ticketListRepository;
    }

    public Observable<List<TicketSummary>> getTicketsSummary(Integer userId, Integer ticketStatusId) {
        return ticketListRepository.getTicketsSummary(userId, ticketStatusId);
    }

    public Observable<TicketInfo> getTicketInfo(Integer ticketId) {
        return ticketListRepository.getTicketInfo(ticketId);
    }
}
