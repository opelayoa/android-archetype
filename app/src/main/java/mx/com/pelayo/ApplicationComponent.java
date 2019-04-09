package mx.com.pelayo;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.pelayo.modules.ApplicationModule;
import mx.com.pelayo.modules.api.ApiModule;
import mx.com.pelayo.modules.database.DatabaseModule;
import mx.com.pelayo.modules.network.NetworkModule;
import mx.com.pelayo.repository.TicketAddRepository;
import mx.com.pelayo.ui.LoginActivity;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.ui.grid.GridFragment;
import mx.com.pelayo.ui.splash.SplashActivity;
import mx.com.pelayo.ui.ticket.add.AddTicketFragment;
import mx.com.pelayo.ui.ticket.detail.TicketDetailFragment;
import mx.com.pelayo.ui.ticket.list.ListTicketFragment;

@Singleton
@Component(modules = {ApplicationModule.class
        , DatabaseModule.class
        , NetworkModule.class
        , ApiModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(GridFragment gridFragment);

    void inject(AddTicketFragment addTicketFragment);

    void inject(ListTicketFragment listTicketFragment);

    void inject(TicketDetailFragment ticketDetailFragment);

    void inject(SplashActivity splashActivity);
}
