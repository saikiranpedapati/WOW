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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

public class SellActivitypage2 extends AppCompatActivity {
    public static  final int PERMISSION_CODE =1001;
    public static  final int IMAGE_CAPTURE_CODE=1000;
    public static final int IMAGE_PICK_CODE =1000;

//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("imagedata").update(updates);
DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("imagesdescription");

    Button capturebtn;
    ImageView image;
    Uri image_uri;
    Button submit;
    String pic;
    int val;
    int count =0;
    EditText description;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_activitypage2);
        description = findViewById(R.id.discription);

        Intent intent=getIntent();
        final String img=intent.getStringExtra("images");


        image = findViewById(R.id.image_View);

        capturebtn = findViewById(R.id.takeaphoto);
        submit = findViewById(R.id.button);
        description = findViewById(R.id.discription);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((count ==0) || (description.getText().toString().isEmpty())) {
                    Toast.makeText(SellActivitypage2.this, "enter all fields", Toast.LENGTH_SHORT).show();

                }
                else{
//
                    String describeInfo=description.getText().toString();
                    String picinfo=pic.toString();


//                    ProductUpload imagesuploading = new ProductUpload(describeInfo);
                    Random random = new Random();
                    val = random.nextInt(1000000000-100000000)+100000000;

                    StorageReference ref = FirebaseStorage.getInstance().getReference().child("img"+val+  describeInfo);







                    ref.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(SellActivitypage2.this, "uploaded", Toast.LENGTH_SHORT).show();




//                           DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
//                            String picture=image.toString();

//                           String describeInfo=description.getText().toString();
//
//                           ProductUpload imagesuploading = new ProductUpload(describeInfo);
//                           databaseReference.push().setValue(imagesuploading);

                        }
                    });

//                    String describeInfo=description.getText().toString();

                    productUpload2 uploadimg = new productUpload2(describeInfo,picinfo);

                    databaseReference.push().setValue(uploadimg);


                    count =1;
//                    databaseReference.push().setValue(imagesuploading);
//                    startActivity(new Intent(SellActivitypage2.this,BuyActivitypage2.class));
//
                }

            }
        });
//
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


        });
    }

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

//        String desc=description.getText().toString();
        if(requestCode==2){
            if (resultCode == RESULT_OK  ) {
                //setting image captured to imageview
                pic = image_uri.toString();

                image.setImageURI(image_uri);
                count=1;

            }
        }
    }




}