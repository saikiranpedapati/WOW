package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class sellActivitypage extends AppCompatActivity {

    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int IMAGE_CODE = 103;
    //    public static final int CAMERA_REQUEST_CODE = 102;
    Uri imageUrl;
    ProgressDialog progressDialog;
    Drawable im;


    ImageView selectedImage;
    Button camera;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    EditText description;
    Button insert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_activitypage);

        selectedImage = findViewById(R.id.imageView1);
        camera = findViewById(R.id.camera1);
        description = findViewById(R.id.Enterdescription);
        insert = findViewById(R.id.insertImage1);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("image");
        firebaseStorage=FirebaseStorage.getInstance();
        progressDialog =new ProgressDialog(this);





        selectedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image");
                startActivityForResult(intent, IMAGE_CODE);
            }
        });









        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                askCameraPermissions();
            }
        });



    }


    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
        }
        else {
            openCamera();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, "camera perm required", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, sellActivitypage.CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_REQUEST_CODE){
            Bitmap image= (Bitmap) data.getExtras().get("data");
            selectedImage.setImageBitmap(image);
        }

        if (requestCode==IMAGE_CODE && requestCode==RESULT_OK){
            imageUrl=data.getData();
//            StorageReference reference=firebaseStorage.getReference();
//            reference.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Toast.makeText(sellActivitypage.this,"uploded",Toast.LENGTH_SHORT).show();
//                }
//            });

            selectedImage.setImageURI(imageUrl);

            StorageReference ref = firebaseStorage.getReference().child("kk");
            ref.putFile(data.getData()).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(sellActivitypage.this, "uploaded", Toast.LENGTH_SHORT).show();

                }
            });

            im = selectedImage.getDrawable();
        }

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                StorageReference ref = firebaseStorage.getReference().child("kk");
//                StorageReference filepath= firebaseStorage.getReference().child("image").child(imageUrl.getLastPathSegment());
//                filepath.putFile(data.getData()).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(sellActivitypage.this, "uploaded", Toast.LENGTH_SHORT).show();
//
//                    }
//                });


            }
        });


        //        another code for submit button
//        insert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StorageReference reference=firebaseStorage.getReference();
////
////                StorageReference reference = FirebaseStorage.getInstance().getReference();
//                UploadTask.TaskSnapshot putFile;
////                imageUrl = getContentResolver().insert(data.getData());
//                reference.putFile(imageUrl);
//
//                reference.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                ProductUpload upload = new ProductUpload();
//
//                                upload.setSelectedImage(uri.toString());
//                                upload.setDescription(description.getText().toString());
//
//                                firebaseDatabase.getReference().child("imagedata").push().setValue(upload).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//
//                                        Toast.makeText(sellActivitypage.this,"image uploded",Toast.LENGTH_SHORT).show();
//
//                                    }
//                                }).addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(sellActivitypage.this,"error uploading",Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//                        });
//
//                    }
//                });
//
//            }
//        });








        ///// insert button code for uploading

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc=description.getText().toString();

                if (!(desc.isEmpty() && imageUrl!=null))
                {
                    progressDialog.setTitle("uploading");
                    progressDialog.show();

                    StorageReference filepath= firebaseStorage.getReference().child("image").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {



                            Task<Uri> downlaodUrl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {

                                    String t=task.getResult().toString();




                                    DatabaseReference newpost= databaseReference.push();
                                    newpost.child("Description").setValue(desc);
                                    newpost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();



                                }
                            });

                        }
                    });

                }

            }

        });

        ///   checking wheather it is going into the loop

//        Toast.makeText(this,"uploading",Toast.LENGTH_SHORT).show();


    }






}