package mx.com.pelayo.modules;

import android.app.Application;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private static final String TAG = ApplicationModule.class.getSimpleName();

    private Application application;
    private String configurationPath;

    public ApplicationModule(Application application, String configurationPath) {
        this.application = application;
        this.configurationPath = configurationPath;
    }

    @Singleton
    @Provides
    public ExecutorService provideExecutorService() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * Regresa el contexto Android necesario para la creación de los helpers y para acceder a recursos del sistema
     *
     * @return contexto en objeto Application
     * @see Application
     */
    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    /**
     * Crea la instancia de la clase Gson, la cual nos ayuda en el parseo de las respuestas enviadas por
     * backend en las llamadas que realicemos
     *
     * @return instancia de Gson
     */
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    /**
     * Obtiene la configuración local (config.json), la cual tiene parámetros necesarios para el funcionamiento
     * de instancias
     *
     * @param gson que ayuda al parseo del archivo (config.json)
     * @return instancia de JsonObject la cual es la configuración local
     */
    @Provides
    @Singleton
    public JsonObject provideLocalConfiguration(
            Gson gson
    ) {
        AssetManager assetManager = application.getAssets();
        JsonObject jsonObject = null;
        try {
            jsonObject = gson.fromJson(new InputStreamReader(assetManager.open(configurationPath)), JsonObject.class);
        } catch (IOException e) {
            Log.e(TAG, "Error loading local configuration", e);
        }
        return jsonObject;
    }
}
