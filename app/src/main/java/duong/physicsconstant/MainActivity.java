package duong.physicsconstant;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.AsyncTaskLoader;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.PublicKey;

import duong.physicsconstant.data.ConstantContract;
import duong.physicsconstant.data.DatabaseOpenHelper;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    public CustomAdapter adapter;
    String tableName = ConstantContract.ClassicalMechanics.TABLE_NAME;
    Uri fakeUri = Uri.parse("");
    public DatabaseOpenHelper databaseOpenHelper;
    public Cursor cursor;;
    ListView listView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        databaseOpenHelper = new DatabaseOpenHelper(this);
        cursor = databaseOpenHelper.getItem(tableName);

        listView = (ListView) findViewById(R.id.list_view);

        adapter = new CustomAdapter(this, cursor);

        listView.setAdapter(adapter);
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

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

        if (id == R.id.classical_mechanics) {
            // Handle the camera action
            tableName = ConstantContract.ClassicalMechanics.TABLE_NAME;
        } else if (id == R.id.thermal_dynamics) {
            tableName = ConstantContract.ThermalDynamics.TABLE_NAME;
        } else if (id == R.id.prefix) {
            tableName = ConstantContract.Prefix.TABLE_NAME;
        } else if (id == R.id.electro_magnetics) {
            tableName = ConstantContract.ElectroMagnetism.TABLE_NAME;
        } else if (id == R.id.optics){
            tableName = ConstantContract.Optics.TABLE_NAME;
        } else if (id == R.id.nuclear_physics){
            tableName = ConstantContract.NuclearPhysics.TABLE_NAME;
        } else if (id == R.id.length_conversion){
            tableName = ConstantContract.LengthConversion.TABLE_NAME;
        }

        cursor = databaseOpenHelper.getItem(tableName);
        adapter = new CustomAdapter(this, cursor);
        listView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPause() {
        if(adView!= null) adView.pause();
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        if (adView!= null) adView.resume();
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        if( adView!= null) adView.destroy();
        super.onDestroy();
    }
}
