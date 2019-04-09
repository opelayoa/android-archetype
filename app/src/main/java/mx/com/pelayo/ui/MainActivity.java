package mx.com.pelayo.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.ui.home.HomeFragment;
import mx.com.pelayo.viewmodel.SecurityViewModel;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    SecurityViewModel securityViewModel;

    @Inject
    SharedPreferences sharedPreferences;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private boolean toolBarNavigationListenerIsRegistered = false;

    private LinearLayout banner;
    private TextView labelName;
    private TextView labelPuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        labelName = findViewById(R.id.labelName);
        labelPuesto = findViewById(R.id.labelPuesto);
        initToolbar();
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        int count = getSupportFragmentManager().getBackStackEntryCount();
        securityViewModel.getUsuarioInformationLiveData().observe(this, userInformation -> {
            labelName.setText(userInformation.getNombre() + " " + userInformation.getApellido());
            if (userInformation.getPuesto_desc() != null) {
                labelPuesto.setText(userInformation.getPuesto_desc());
            } else {
                labelPuesto.setVisibility(GONE);
            }

        });
        if (count == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, new HomeFragment(), "home")
                    .addToBackStack("home")
                    .commit();
        }

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void hideBanner() {
        enableViews(true);
    }

    public void showBanner() {
        enableViews(false);
    }

    private void enableViews(boolean enable) {
        if (enable) {
            banner.setVisibility(GONE);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            toggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (!toolBarNavigationListenerIsRegistered) {
                toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
                toolBarNavigationListenerIsRegistered = true;
            }
        } else {
            banner.setVisibility(View.VISIBLE);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            toggle.setDrawerIndicatorEnabled(true);
            toggle.setToolbarNavigationClickListener(null);
            toolBarNavigationListenerIsRegistered = false;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            int count = fragmentManager.getBackStackEntryCount();
            if (count == 1) {
                finish();
            } else {
                fragmentManager.popBackStack();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_sync) {
        } else if (id == R.id.nav_sign_out) {
            sharedPreferences
                    .edit()
                    .clear()
                    .commit();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
