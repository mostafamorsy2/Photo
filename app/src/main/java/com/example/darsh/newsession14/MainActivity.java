package com.example.darsh.newsession14;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentTransaction mFragmentTransaction;
    private AlertDialog.Builder dialog;
    String privacy="Disclaimer: " +
            "\n Some Wallpapers used in our application are copyright to their respectiv" +
            "e owners and usage falls within the \"Fair Usage\" guidelines." +
            " And all the Artworks downloaded are for personal use only." +
            " For any commercial purpose, please contact the artist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavigationView = findViewById(R.id.navigationView);


        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        //mFragmentTransaction.replace(R.id.fragmentPlace, new HomeFragment());
        mFragmentTransaction.replace(R.id.fragmentPlace,new HomeFragment());
        mFragmentTransaction.commit();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, (R.string.open), (R.string.close));
        mDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                mFragmentTransaction.replace(R.id.fragmentPlace, new HomeFragment());
                mFragmentTransaction.commit();
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_privacy:

                dialog=new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("");
                dialog.setMessage(privacy);
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.btn_dialog);
                dialog.setPositiveButton(getResources().getString(R.string.iagree), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog =dialog.create();
                alertDialog.show();

                break;
            case R.id.nav_settings:
                Intent intent=new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
                break;
            case R.id.exit:
                finish();
                System.exit(0);
                break;
        }
        return true;
    }
}
