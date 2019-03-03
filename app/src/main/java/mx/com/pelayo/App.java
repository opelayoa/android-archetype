package mx.com.pelayo;



import android.app.Application;

import mx.com.pelayo.modules.ApplicationModule;

public class App extends Application {

    ApplicationComponent component;
    private static final String CONFIG_PATH = "config.json";

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, CONFIG_PATH))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return component;
    }
}
