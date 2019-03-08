package mx.com.pelayo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.viewmodel.SecurityViewModel;
import mx.com.pelayo.viewmodel.UsuarioViewModel;
import retrofit2.HttpException;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "XxX";
    @Inject
    SecurityViewModel securityViewModel;

    @Inject
    UsuarioViewModel usuarioViewModel;

    private EditText username;
    private EditText password;
    private Button login;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        /*syncViewModel
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
                });*/
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this::onClick);

    }

    @SuppressLint("CheckResult")
    private void onClick(View view) {
        securityViewModel
                .login(username.getText().toString(),
                        password.getText().toString(),
                        "Basic Y2xpZW50OnNlY3JldA==")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver() {
                    @Override
                    public void onNext(Object object) {
                        Toast.makeText(LoginActivity.this, object.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            int code = httpException.code();
                            Toast.makeText(LoginActivity.this, "Código <> " + code, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(LoginActivity.this, e.getClass() + " <>" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(LoginActivity.this, "Ok!", Toast.LENGTH_SHORT).show();
                    }
                });
        ;
    }
}
