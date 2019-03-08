package mx.com.pelayo.api;

import io.reactivex.Observable;
import mx.com.pelayo.database.entities.security.Session;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SecurityService {

    @POST("oauth/token")
    @FormUrlEncoded
    Observable<Session> login(@Field("username") String username,
                              @Field("password") String password,
                              @Field("grant_type") String grantType,
                              @Header("Authorization") String basic);

    @POST("oauth/token")
    Observable<Session> refreshToken(@Field("refresh_token") String refreshToken,
                                     @Field("grant_type") String grantType,
                                     @Header("Authorization") String basic);

}
