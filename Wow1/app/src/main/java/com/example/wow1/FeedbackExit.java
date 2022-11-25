package com.example.wow1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedbackExit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_exit);

        // fragmentmanager to manage code
        FragmentManager fragmentManager = getSupportFragmentManager();


        /// feedback fragment

        Button feedback= findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, FeedbackFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("feedback")
                        .commit();

            }
        });

        ///exit fragment

        Button exit= findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2,ExitFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("exit")
                        .commit();

            }
        });

    }
}