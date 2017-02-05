package com.example.anubharora.materialdesigncomponents;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.anubharora.materialdesigncomponents.fragments.AttachmentFragment;
import com.example.anubharora.materialdesigncomponents.fragments.ImagesFragment;
import com.example.anubharora.materialdesigncomponents.fragments.LocationFragment;
import com.example.anubharora.materialdesigncomponents.fragments.SubItem1Fragment;
import com.example.anubharora.materialdesigncomponents.fragments.SubItem2Fragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                moveToTheFragment(item);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        FloatingActionButton floationActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floationActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.drawer_layout), "Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //add an action on click on the snackbar
                                Toast.makeText(MainActivity.this, "SnackBar Clicked", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });


    }

    private void moveToTheFragment(MenuItem item) {
        Fragment fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //FrameLayout framelayout = (FrameLayout) findViewById(R.id.frame);
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.navigation_item_attachment:
                fragment = new AttachmentFragment();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.navigation_item_images:
                fragment = new ImagesFragment();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.navigation_item_location:
                fragment = new LocationFragment();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.sub_item1:
                fragment = new SubItem1Fragment();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.sub_item2:
                fragment = new SubItem2Fragment();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
