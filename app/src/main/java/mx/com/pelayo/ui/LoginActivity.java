package mx.com.pelayo.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.ui.util.DialogFactory;
import mx.com.pelayo.util.Tools;
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
    private Dialog progressDialog;
    private Dialog errorDialog;

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
        progressDialog = DialogFactory.getProgressDialog(this, "Autenticando...");
        progressDialog.show();
        securityViewModel
                .login(username.getText().toString(),
                        password.getText().toString(),
                        "Basic Y2xpZW50OnNlY3JldA==")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                            if (data.getStatus() == 0 || data.getStatus() == 2) {
                                progressDialog.dismiss();
                                sync();
                            } else {
                                progressDialog.dismiss();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        , throwable -> {
                            progressDialog.dismiss();
                            errorDialog = DialogFactory.getErrorDialog(this, "Usuario y/o contraseña incorrecta.");
                            errorDialog.show();
                        });

    }

    private void sync() {
        progressDialog = DialogFactory.getProgressDialog(this, "Sincronizando...");
        progressDialog.show();
        syncViewModel.sync()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver() {

                    @Override
                    public void onNext(Object o) {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        progressDialog.dismiss();
                        errorDialog = DialogFactory.getErrorDialog(LoginActivity.this, Tools.parseError(throwable));
                        errorDialog.show();
                    }

                    @Override
                    public void onComplete() {
                        progressDialog.dismiss();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
