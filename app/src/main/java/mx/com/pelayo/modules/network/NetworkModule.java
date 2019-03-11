package mx.com.pelayo.modules.network;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.pelayo.network.aurhenticator.ApiAuthenticator;
import mx.com.pelayo.network.interceptor.ApiInterceptor;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static final String API = "api";
    private static final String CACHE_SIZE = "cache_size";
    private static final String CONNECT_TIMEOUT = "connect_timeout";
    private static final String READ_TIMEOUT = "read_timeout";
    private static final String WRITE_TIMEOUT = "write_timeout";
    private static final String BASE_URL = "base_url";
    public static final String OAUTH2 = "oauth2";

    /**
     * Crea la instancia de Caché necesaria para guardar de forma temporal las respuestas a llamadas
     * que tiendan a repetirse
     *
     * @param application        contexto de Android
     * @param localConfiguration configuración local
     * @return cache configurado
     */
    @Provides
    @Singleton
    public Cache provideCache(
            Application application,
            JsonObject localConfiguration
    ) {
        return new Cache(
                application.getCacheDir(),
                localConfiguration.getAsJsonObject(API).getAsJsonPrimitive(CACHE_SIZE).getAsInt()
        );
    }

    /**
     * Crea la instancia OkHttpClient necesaria para las llamadas a backend
     *
     * @param localConfiguration configuración local
     * @param cache              cache para guardar datos de forma temporal
     * @param authInterceptor    Interceptor que ayuda a poner el AuthToken sin necesidad de tocar la llamada
     * @param authenticator      Authenticator que ayuda a resolver llamadas con respuesta de error (400, 401, 402, etc...)
     * @return OkHttpClient creado para llamadas REST a backend
     * @see ApiInterceptor
     * @see ApiAuthenticator
     */
    @Provides
    @Named("httpClient")
    @Singleton
    public OkHttpClient provideHttpClient(
            JsonObject localConfiguration,
            Cache cache,
            ApiInterceptor authInterceptor,
            ApiAuthenticator authenticator
    ) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(localConfiguration.getAsJsonObject(API).getAsJsonPrimitive(CONNECT_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .readTimeout(localConfiguration.getAsJsonObject(API).getAsJsonPrimitive(READ_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .writeTimeout(localConfiguration.getAsJsonObject(API).getAsJsonPrimitive(WRITE_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .authenticator(authenticator)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    /**
     * Crea la instancia OkHttpClient necesaria para las llamadas a backend para OAuth2
     *
     * @param localConfiguration configuración local
     * @param cache              cache para guardar datos de forma temporal
     * @return OkHttpClient creado para llamadas REST a backend
     * @see ApiInterceptor
     * @see ApiAuthenticator
     */
    @Provides
    @Named("httpClientOAuth2")
    @Singleton
    public OkHttpClient provideHttpClientOAuth2(
            JsonObject localConfiguration,
            Cache cache
    ) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(localConfiguration.getAsJsonObject(OAUTH2).getAsJsonPrimitive(CONNECT_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .readTimeout(localConfiguration.getAsJsonObject(OAUTH2).getAsJsonPrimitive(READ_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .writeTimeout(localConfiguration.getAsJsonObject(OAUTH2).getAsJsonPrimitive(WRITE_TIMEOUT).getAsInt(), TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    /**
     * Crea la instancia de Retrofit necesaria para crear los objetos que pueden realizar llamadas
     * a backend a partir de la interface Api enviada como clase a la instancia
     * <code>
     * retrofit.create(ApiClass.class)
     * </code>
     *
     * @param okHttpClient       instancia de OkHttpCliente que sirve para hacer la llamada
     * @param localConfiguration configuración local
     * @param gson               parser de respuestas de backend
     * @return instancia Retrofit para creación de instancias de interfaces Api
     */
    @Provides
    @Named("retrofit")
    @Singleton
    public Retrofit provideRetrofit(
            @Named("httpClient") OkHttpClient okHttpClient,
            JsonObject localConfiguration,
            Gson gson
    ) {
        return new Retrofit.Builder()
                .baseUrl(localConfiguration.getAsJsonObject(API).getAsJsonPrimitive(BASE_URL).getAsString())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * Crea la instancia de Retrofit necesaria para crear los objetos que pueden realizar llamadas
     * a backend a partir de la interface Api enviada como clase a la instancia
     * <code>
     * retrofit.create(ApiClass.class)
     * </code>
     *
     * @param okHttpClient       instancia de OkHttpCliente que sirve para hacer la llamada
     * @param localConfiguration configuración local
     * @param gson               parser de respuestas de backend
     * @return instancia Retrofit para creación de instancias de interfaces Api
     */
    @Provides
    @Named("retrofitOAuth2")
    @Singleton
    public Retrofit provideRetrofitOAuth2(
            @Named("httpClientOAuth2") OkHttpClient okHttpClient,
            JsonObject localConfiguration,
            Gson gson
    ) {
        return new Retrofit.Builder()
                .baseUrl(localConfiguration.getAsJsonObject(OAUTH2).getAsJsonPrimitive(BASE_URL).getAsString())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
