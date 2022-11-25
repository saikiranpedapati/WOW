package com.example.wow1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class AfterLogin extends AppCompatActivity {

//    ListView listView;

//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Button sell=findViewById(R.id.sell3);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLogin.this,sellActivitypage.class));
            }
        });

        Button buy=findViewById(R.id.buy3);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLogin.this,buyActivitypage.class));
            }
        });

        Button feedbackexit=findViewById(R.id.feedbackexit);
        feedbackexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLogin.this,FeedbackExit.class));
            }
        });







/////////// check activity no 17 for listview implementation



//        tabLayout = findViewById(R.id.tablayout);
//        viewPager=findViewById(R.id.viewpager);
//
//
//        tabLayout.setupWithViewPager(viewPager);
//
//        wowAdapter wowAdapter=new wowAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        wowAdapter.addFragment(new SellFragment(),"sell");
//        wowAdapter.addFragment(new BuyFragment(),"buy");
//        viewPager.setAdapter(wowAdapter);
//
//






    }


}