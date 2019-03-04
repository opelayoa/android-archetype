package mx.com.pelayo.modules.api;

import dagger.Module;
import dagger.Provides;
import mx.com.pelayo.api.TdeService;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public TdeService provideTdeService(Retrofit retrofit) {
        return retrofit.create(TdeService.class);
    }
}
