package mx.com.pelayo;

import javax.inject.Singleton;

import dagger.Component;
import mx.com.pelayo.modules.ApplicationModule;
import mx.com.pelayo.modules.database.DatabaseModule;

@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
