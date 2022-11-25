package com.example.wow1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NewWelcomeScreen extends AppCompatActivity {

    BottomNavigationView nav;
    SellFragment sellFragment = new SellFragment();
    BuyFragment buyFragment = new BuyFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_welcome_screen);


        nav = findViewById(R.id.nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, sellFragment).commit();

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.sell:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, sellFragment).commit();
                        return true;
                    case R.id.buy:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, buyFragment).commit();
                        return true;

                }
                return false;
            }
        });



    }
}