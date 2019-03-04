package mx.com.pelayo;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mx.com.pelayo.adapter.UsuarioAdapter;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.viewmodel.UsuarioViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    UsuarioViewModel usuarioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);

        List<Usuario> usuarios = new ArrayList<Usuario>();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UsuarioAdapter adapter = new UsuarioAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        usuarioViewModel.getAll().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(@Nullable List<Usuario> usuarios) {
                adapter.setUsuarios(usuarios);
            }
        });

        //Usuario usuario = new Usuario();
        //usuario.setId(1);
        //usuarios.add(usuario);

        //usuarioViewModel.insert(usuario);

        //usuario = new Usuario();
        //usuario.setId(2);
        //usuarios.add(usuario);

        //usuarioViewModel.insert(usuario);
        //usuarioViewModel.insertAll(usuarios);
        usuarioViewModel.sync();


    }
}
