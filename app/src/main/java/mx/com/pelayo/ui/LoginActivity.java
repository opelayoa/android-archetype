package mx.com.pelayo.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.viewmodel.SecurityViewModel;
import mx.com.pelayo.viewmodel.SyncViewModel;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "XxX";
    @Inject
    SecurityViewModel securityViewModel;

    @Inject
    SyncViewModel syncViewModel;

    private EditText username;
    private EditText password;
    private Button login;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(this::login);

    }

    @SuppressLint("CheckResult")
    private void login(View view) {
        securityViewModel
                .login(username.getText().toString(),
                        password.getText().toString(),
                        "Basic Y2xpZW50OnNlY3JldA==")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                            if (data.getStatus() == 0 || data.getStatus() == 2) {
                                sync();
                            } else {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        , throwable -> {
                            System.out.println("Error: " + throwable.toString());
                        });

    }

    private void sync() {
        syncViewModel.sync()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver() {

                    @Override
                    public void onNext(Object o) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(LoginActivity.this, "Error al sincronizar..." + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
