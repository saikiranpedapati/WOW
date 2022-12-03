package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class NewUser extends AppCompatActivity {

    EditText personname, email,phone,password;
//    DatabaseReference databaseReference;


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("getdata");

//    private FirebaseAuth auth;
//    private EditText loginEmail,LoginPassword;
//    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

//
//        auth=FirebaseAuth.getInstance();
//        loginEmail=findViewById(R.id.);

        personname=findViewById(R.id.editTextTextPersonName);
        email=findViewById(R.id.editTextTextEmailAddress2);
        phone=findViewById(R.id.editTextPhone);
        password=findViewById(R.id.editTextTextPassword2);

        Button button3=findViewById(R.id.button3);

//        databaseReference=FirebaseDatabase.getInstance().getReference().child("getdata");


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personnametxt=personname.getText().toString();
                String emailtxt=email.getText().toString();
                String phonetxt=phone.getText().toString();
                String passwordtxt=password.getText().toString();




                if (personnametxt.isEmpty()){
                    personname.setError("enter a name!");
                    personname.requestFocus();
                    return;
                }
                if (emailtxt.isEmpty()){
                    email.setError("enter a Email ID!");
                   email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()) {
                    email.setError("Please provide a valid Email Address!");
                    email.requestFocus();
                    return;
                }
                if (phonetxt.isEmpty()){
                    phone.setError("enter phone no!");
                    phone.requestFocus();
                    return;
                }
                if(phonetxt.length() < 10){
                    phone.setError("enter valid mobile no!");
                    phone.requestFocus();
                    return;
                }

                if (passwordtxt.isEmpty()){
                    password.setError("Password is required!");
                    password.requestFocus();
                    return;
                }
                if(passwordtxt.length() < 8){
                    password.setError("Min password length should be 6 characters!");
                    password.requestFocus();
                    return;
                }


                if(personnametxt.isEmpty() ||emailtxt.isEmpty() ||phonetxt.isEmpty() ||passwordtxt.isEmpty()){

                    Toast.makeText(NewUser.this,"enter all details",Toast.LENGTH_SHORT).show();
                }



//                else{
//
//                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if(snapshot.hasChild(phonetxt)){
//                                Toast.makeText(NewUser.this,"user already registered",Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                databaseReference.child("users").child(phonetxt).child("personname").setValue(personnametxt);
//                                databaseReference.child("users").child(phonetxt).child("email").setValue(emailtxt);
//                                databaseReference.child("users").child(phonetxt).child("password").setValue(passwordtxt);
//
//                                Toast.makeText(NewUser.this,"successfully registered",Toast.LENGTH_SHORT).show();
//                                finish();
//
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });

//                    databaseReference.child("users").child(phonetxt).child("personname").setValue(personnametxt);
//                    databaseReference.child("users").child(phonetxt).child("email").setValue(emailtxt);
//                    databaseReference.child("users").child(phonetxt).child("password").setValue(passwordtxt);
//
//                    Toast.makeText(NewUser.this,"successfully registered",Toast.LENGTH_SHORT).show();
//                    finish();

//                }

                else{
//                    System.out.println("happy");
                    Toast.makeText(NewUser.this,"successfully registered",Toast.LENGTH_SHORT).show();


                        String name=personname.getText().toString();
                        String mail=email.getText().toString();
                        String phoneno=phone.getText().toString();
                        String pass=password.getText().toString();



                        userLogin Logincred = new userLogin(name,mail,phoneno,pass);
                        databaseReference.push().setValue(Logincred);


                }




            }



        });




//          backbuttontopreviouspage
        Button back;
        back=findViewById(R.id.button4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(NewUser.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });
        //end


    }
//    public void user()
//    {
//        String name=personname.getText().toString();
//        String mail=email.getText().toString();
//        String phoneno=phone.getText().toString();
//        String pass=password.getText().toString();
//
//        userLogin Logincred = new userLogin(name,mail,phoneno,pass);
//        databaseReference.push().setValue(Logincred);
//
//    }





}