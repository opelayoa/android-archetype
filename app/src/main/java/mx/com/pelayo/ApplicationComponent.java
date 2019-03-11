package mx.com.pelayo;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.pelayo.modules.ApplicationModule;
import mx.com.pelayo.modules.api.ApiModule;
import mx.com.pelayo.modules.database.DatabaseModule;
import mx.com.pelayo.modules.network.NetworkModule;
import mx.com.pelayo.ui.LoginActivity;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.ui.grid.GridFragment;

@Singleton
@Component(modules = {ApplicationModule.class
        , DatabaseModule.class
        , NetworkModule.class
        , ApiModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(GridFragment gridFragment);
}