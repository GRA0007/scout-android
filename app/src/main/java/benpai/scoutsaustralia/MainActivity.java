package benpai.scoutsaustralia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Boolean showFAB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        setTitle(R.string.menu_about);
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new AboutFragment(), "AboutFragment")
                .commit();
        findViewById(R.id.fab).setVisibility(View.INVISIBLE);
        showFAB = false;
        ViewCompat.setElevation((View) findViewById(R.id.toolbar).getParent(), 8);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_about) {
            setTitle(R.string.menu_about);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AboutFragment(), "AboutFragment")
                    .commit();
            findViewById(R.id.fab).setVisibility(View.INVISIBLE);
            showFAB = false;
            ViewCompat.setElevation((View) findViewById(R.id.toolbar).getParent(), 8);
        } else if (id == R.id.nav_award_scheme) {
            setTitle(R.string.menu_award_scheme);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AwardSchemeFragment(), "AwardSchemeFragment")
                    .commit();
            findViewById(R.id.fab).setVisibility(View.INVISIBLE);
            showFAB = false;
            ViewCompat.setElevation((View) findViewById(R.id.toolbar).getParent(), 8);
        } else if (id == R.id.nav_progress_tracker) {
            setTitle(R.string.menu_progress_tracker);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ProgressTrackerFragment(), "ProgressTrackerFragment")
                    .commit();
            findViewById(R.id.fab).setVisibility(View.VISIBLE);
            showFAB = true;
            ViewCompat.setElevation((View) findViewById(R.id.toolbar).getParent(), 0);
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, PreferencesActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (getTitle() == getResources().getString(R.string.menu_about)) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AboutFragment(), "AboutFragment")
                    .commit();
        } else if (getTitle() == getResources().getString(R.string.menu_award_scheme)) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new AwardSchemeFragment(), "AwardSchemeFragment")
                    .commit();
        } else if (getTitle() == getResources().getString(R.string.menu_progress_tracker)) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ProgressTrackerFragment(), "ProgressTrackerFragment")
                    .commit();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Fragment curFragment = getSupportFragmentManager().findFragmentByTag("AwardSchemeFragment");
        if (curFragment != null && curFragment.isVisible()) {
            ExpandableListView listView = (ExpandableListView) findViewById(R.id.award_scheme_list);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            int left = width - AwardSchemeFragment.GetPixelFromDips(35, this);
            int right = width - AwardSchemeFragment.GetPixelFromDips(5, this);
            AwardSchemeFragment.positionChevron(left, right, listView);
        }
        super.onConfigurationChanged(newConfig);
    }
}
