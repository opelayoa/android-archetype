package mx.com.pelayo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.ui.home.HomeFragment;
import mx.com.pelayo.viewmodel.SecurityViewModel;

public class MainActivity extends AppCompatActivity {

    @Inject
    SecurityViewModel securityViewModel;

    private FragmentManager fragmentManager;

    private TextView labelName;
    private TextView labelPuesto;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        labelName = findViewById(R.id.labelName);
        labelPuesto = findViewById(R.id.labelPuesto);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        int count = getSupportFragmentManager().getBackStackEntryCount();
        securityViewModel.getUsuarioActual().observe(this, usuarioActual -> {
            labelName.setText(usuarioActual.usuarioActual.getNombre().trim() + " " + usuarioActual.usuarioActual.getApellido().trim());
            labelPuesto.setText(usuarioActual.puestos.get(0).getNombre());
        });
        if (count == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }

    private void initToolbar() {
        linearLayout = findViewById(R.id.banner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ticket Doctor Express");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Tools.setSystemBarColor(this);
    }

    public void hideBanner() {
        linearLayout.setVisibility(View.GONE);
    }

    public void showBanner() {
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }
}
