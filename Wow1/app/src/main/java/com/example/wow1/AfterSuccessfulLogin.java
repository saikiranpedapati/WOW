package com.example.wow1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AfterSuccessfulLogin extends AppCompatActivity {

    int CameraRequestCode= 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_successful_login);

        // fragmentmanager to manage code
        FragmentManager fragmentManager = getSupportFragmentManager();


        /// sellbutton fragment

        Button sell= findViewById(R.id.sell);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, SellFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("sell")
                        .commit();

            }
        });

        ///buybutton fragment

        Button buy= findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,BuyFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("buy")
                        .commit();

            }
        });










//        ImageView cam;
//
//        cam=findViewById(R.id.Camerabtn);
//        cam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(ActivityCompat.checkSelfPermission(AfterSuccessfulLogin.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(AfterSuccessfulLogin.this,new String[]{Manifest.permission.CAMERA},22);
//                }
//                else
//                {
//                    Intent CameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(CameraIntent,CameraRequestCode);
//
//
//                }
//            }
//        });




    }
}