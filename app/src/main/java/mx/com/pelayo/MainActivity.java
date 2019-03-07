package mx.com.pelayo;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.adapter.UsuarioAdapter;
import mx.com.pelayo.database.entities.Distrito;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.viewmodel.SyncViewModel;
import mx.com.pelayo.viewmodel.UsuarioViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "XxX";
    @Inject
    SyncViewModel syncViewModel;

    @Inject
    UsuarioViewModel usuarioViewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);

        List<Usuario> usuarios = new ArrayList<Usuario>();

        /*RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UsuarioAdapter adapter = new UsuarioAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        usuarioViewModel.getAll().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(@Nullable List<Usuario> usuarios) {
                adapter.setUsuarios(usuarios);
            }
        });


        Usuario usuario = new Usuario();
        usuario.setId(3000);
        usuario.setAlias("Oscar Daniel Pelayo Anduaga");
        usuario.setEmail("opa@tiendas3b.com");


        usuarioViewModel.insert(usuario)
                .andThen(Completable.fromAction(() -> Log.i(TAG, "Se inserto el registro ")))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.single())
                .subscribe();*/


        //usuarios.add(usuario);

        //usuarioViewModel.insert(usuario);

        //usuario = new Usuario();
        //usuario.setId(2);
        //usuarios.add(usuario);

        //usuarioViewModel.insert(usuario);
        //usuarioViewModel.insertAll(usuarios);
        syncViewModel
                .sync()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new io.reactivex.Observer<List<Distrito>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Distrito> distritos) {
                        Log.i(TAG, "onNext: " + distritos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.i(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
