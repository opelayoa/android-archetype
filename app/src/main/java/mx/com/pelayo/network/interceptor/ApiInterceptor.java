package mx.com.pelayo.network.interceptor;

import java.io.IOException;

import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class ApiInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        // TODO: Implements interceptor
        return chain.proceed(originalRequest);
    }
}
