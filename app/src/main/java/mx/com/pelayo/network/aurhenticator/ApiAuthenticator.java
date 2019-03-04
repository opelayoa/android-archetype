package mx.com.pelayo.network.aurhenticator;

import android.support.annotation.Nullable;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

@Singleton
public class ApiAuthenticator implements Authenticator {

    @Inject
    public ApiAuthenticator() {
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, Response response) throws IOException {
        // TODO: Implement authentication
        Request request = response
                .request()
                .newBuilder()
                .build();
        return request;
    }
}
