package mx.com.pelayo.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import mx.com.pelayo.R;
import mx.com.pelayo.ui.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindView();
    }

    private void bindView() {
        logo = findViewById(R.id.logo);

        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.logo_fadein_animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goHome();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        logo.startAnimation(animation);
    }

    private void goHome() {
        Thread loading = new Thread() {
            public void run() {
                try {
                    sleep(750);
                    Intent login = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(login);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        loading.start();
    }

}
