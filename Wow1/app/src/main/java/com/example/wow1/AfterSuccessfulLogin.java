package com.example.wow1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ImageView;


public class AfterSuccessfulLogin extends AppCompatActivity {

    int CameraRequestCode= 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_successful_login);
        ImageView cam;

        cam=findViewById(R.id.Camerabtn);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(AfterSuccessfulLogin.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(AfterSuccessfulLogin.this,new String[]{Manifest.permission.CAMERA},22);
                }
                else
                {
                    Intent CameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(CameraIntent,CameraRequestCode);
                }
            }
        });


    }
}