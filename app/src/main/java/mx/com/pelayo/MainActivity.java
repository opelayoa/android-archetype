package mx.com.pelayo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mx.com.pelayo.database.UsuarioRepository;
import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.entities.Usuario;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);

        List<Usuario> usuarios = new ArrayList<Usuario>();

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuarios.add(usuario);

        usuarioRepository.insert(usuario);

        usuario = new Usuario();
        usuario.setId(2);
        usuarios.add(usuario);

        usuarioRepository.insert(usuario);
        usuarioRepository.insertAll(usuarios.toArray(new Usuario[usuarios.size()]));
    }
}
