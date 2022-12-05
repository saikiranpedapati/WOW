package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

public class SellActivitypage2 extends AppCompatActivity {
    public static  final int PERMISSION_CODE =1001;
    public static  final int IMAGE_CAPTURE_CODE=1000;
    public static final int IMAGE_PICK_CODE =1000;

//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("imagedata").update(updates);
DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("images");

    Button capturebtn;
    ImageView image;
    Uri image_uri;
    Uri imager;
    String status;
    TextView txt;
    TextView number;
    Button submit;
    TextView describe;
    String imageexists;
    String pic;
    Button upload;
    int val;
    int k;
    FloatingActionButton deleteimage;
    DatabaseReference issues;
    DatabaseReference issues1;
    int count =0;
    String keka;
    BottomNavigationView nave;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_activitypage2);
        description = findViewById(R.id.discription);


        image = findViewById(R.id.image_View);




        //Intent intent = getIntent ();
        // Bundle extras = intent.getExtras();


        // keka = extras.getString("keynumber");

        // number.setText(keka);


//        txt = findViewById(R.id.random);
        capturebtn = findViewById(R.id.takeaphoto);
        submit = findViewById(R.id.button);
        description = findViewById(R.id.discription);
//        issues = FirebaseDatabase.getInstance().getReference().child("issues table");
//        issues1 = FirebaseDatabase.getInstance().getReference().child("In process");
//        uploadde = findViewById(R.id.uploadaphoto);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((count ==0) || (description.getText().toString().isEmpty())) {
                    Toast.makeText(SellActivitypage2.this, "enter all fields", Toast.LENGTH_SHORT).show();

                }
                else{
//
                    String describeInfo=description.getText().toString();
                    ProductUpload imagesuploading = new ProductUpload(describeInfo);
                    Random random = new Random();
                    val = random.nextInt(1000000000-100000000)+100000000;
                    StorageReference ref = FirebaseStorage.getInstance().getReference().child("img"+val+  describeInfo);
                    ref.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(SellActivitypage2.this, "uploaded", Toast.LENGTH_SHORT).show();




//                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
//                        String describeInfo=description.getText().toString();
//                        String picture=image.toString();
//                        ProductUpload imagesuploading = new ProductUpload(describeInfo,pict);
//                        databaseReference.push().setValue(imagesuploading);

                        }
                    });

                    count =1;
                    databaseReference.push().setValue(imagesuploading);

                }

            }
        });
//        upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
//                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED|| checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
//                        //permission not enabled so request it
//                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
//                        //show popup to request permission
//                        requestPermissions(permission, PERMISSION_CODE);
//
//                    }
//                    else
//                    {
//                        //permission already granted
//                        PickImageFromGallery();
//                    }
//                }
//                else
//                {
//                    //system os is <marsh
//                    PickImageFromGallery();
//                }
//            }
//        });

        //onbuttonclick
        capturebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED|| checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                        //permission not enabled so request it
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //show popup to request permission
                        requestPermissions(permission, PERMISSION_CODE);

                    }
                    else
                    {
                        //permission already granted
                        OpenCamera();
                    }
                }
                else
                {
                    //system os is <marsh
                    OpenCamera();
                }
            }
           /* Random random = new Random();
            int val = random.nextInt(10000);
                txt.setText(Integer.toString(val).concat(" is your ticket ID, please note. We will send you a mail once the issue is resolved, Thnaks for reporting"));*/

        });
    }
//    private void PickImageFromGallery(){
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, 1);
//    }

    private void OpenCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //camera intent
        Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraintent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraintent, 2);

    }
    //handling permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    OpenCamera();
//                    PickImageFromGallery();
                }
                else {
                    Toast.makeText(this, "permission denied..", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==1) {
//            if (resultCode == RESULT_OK || resultCode == IMAGE_PICK_CODE) {
//                //pic = image_uri.toString();
//
//                // image.setImageURI(image_uri);
//                image.setImageURI(data.getData());
//                StorageReference ref = FirebaseStorage.getInstance().getReference().child("kk");
//                ref.putFile(data.getData()).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(SellActivitypage2.this, "uploaded", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                pic = data.getData().toString();
//                count =1;
//
//            }
//        }
//        else                     itis else if statement press back space and join the below line

        String desc=description.getText().toString();
        if(requestCode==2){
            if (resultCode == RESULT_OK  ) {
                //setting image captured to imageview
                pic = image_uri.toString();

                image.setImageURI(image_uri);
                count=1;

                //imager = image_uri;

                ////going into firebase storage
//                Random random = new Random();
//                val = random.nextInt(1000000000-100000000)+100000000;
//                StorageReference ref = FirebaseStorage.getInstance().getReference().child("img"+val+desc);
//                ref.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(SellActivitypage2.this, "uploaded", Toast.LENGTH_SHORT).show();
//
//
//
//
////                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
////                        String describeInfo=description.getText().toString();
////                        String picture=image.toString();
////                        ProductUpload imagesuploading = new ProductUpload(describeInfo,pict);
////                        databaseReference.push().setValue(imagesuploading);
//
//                    }
//                });
//
//                count =1;



//
            }
        }
    }




}