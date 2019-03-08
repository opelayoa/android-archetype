package mx.com.pelayo.modules.api;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import mx.com.pelayo.api.SecurityService;
import mx.com.pelayo.api.TdeService;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public TdeService provideTdeService(@Named("retrofit") Retrofit retrofit) {
        return retrofit.create(TdeService.class);
    }

    @Provides
    public SecurityService provideSecurityService(@Named("retrofitOAuth2") Retrofit retrofit) {
        return retrofit.create(SecurityService.class);
    }
}
