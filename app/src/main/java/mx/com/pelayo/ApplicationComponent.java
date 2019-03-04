package mx.com.pelayo;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.pelayo.modules.ApplicationModule;
import mx.com.pelayo.modules.api.ApiModule;
import mx.com.pelayo.modules.database.DatabaseModule;
import mx.com.pelayo.modules.network.NetworkModule;

@Singleton
@Component(modules = {ApplicationModule.class
        , DatabaseModule.class
        , NetworkModule.class
        , ApiModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
