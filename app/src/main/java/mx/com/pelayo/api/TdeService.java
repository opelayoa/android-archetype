package mx.com.pelayo.api;

import java.util.List;

import mx.com.pelayo.database.entities.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TdeService {

    @GET("usuarios/")
    Call<List<Usuario>> getAllUsuarios();
}
