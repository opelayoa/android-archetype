package mx.com.pelayo.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import mx.com.pelayo.api.TdeService;
import mx.com.pelayo.api.entities.TicketInfo;
import mx.com.pelayo.api.entities.TicketSummary;
import mx.com.pelayo.database.dao.security.UsuarioActualDao;
import mx.com.pelayo.database.entities.custom.UserInformation;

@Singleton
public class TicketListRepository {

    private TdeService tdeService;

    private UsuarioActualDao usuarioActualDao;

    @Inject
    public TicketListRepository(TdeService tdeService, UsuarioActualDao usuarioActualDao) {
        this.tdeService = tdeService;
        this.usuarioActualDao = usuarioActualDao;
    }

    public Observable<TicketInfo> getTicketInfo(Integer ticketId) {
        return tdeService.getTicketInfo(ticketId);
    }

    public Observable<List<TicketSummary>> getTicketsSummary(Integer userId, Integer ticketStateId) {
        return tdeService.getTicketsSummary(userId, ticketStateId);
    }

    public Observable<UserInformation> getUserInformation() {
        Observable<UserInformation> observable = Completable.fromAction(() -> usuarioActualDao.getUsuarioInfo()).toObservable();
        return observable;
    }

}
