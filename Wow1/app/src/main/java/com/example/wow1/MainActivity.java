package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


//    private FirebaseAuth auth;
//    private EditText signupEmail, signupPassword;
//    private Button button1;
//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/");
    DatabaseReference databaseReference;
    DataSnapshot snapshot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phone=findViewById(R.id.editTextPhone2);
        final EditText password=findViewById(R.id.editTextTextPassword);
        final Button login=findViewById(R.id.button1);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("getdata");
//        final Button newuser=findViewById(R.id.button2);

        Button bt2=findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NewUser.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phonetxt=phone.getText().toString();
                final String passwordtxt=password.getText().toString();

                if(phonetxt.isEmpty() || passwordtxt.isEmpty()){
                    Toast.makeText(MainActivity.this,"please enter your mobile or password",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.orderByChild("phone").equalTo(phone.getText().toString()).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                            if(snapshot.hasChildren()){
                                userLogin login=snapshot.getValue(userLogin.class);
                                String pass1= login.getPass().toString();
                                if(passwordtxt.equals(pass1))
                                {
                                    Intent intent = new Intent(getApplicationContext(),NewWelcomeScreen.class);

                                    intent.putExtra("passwords",pass1);

                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this,"Phone no or password is wrong",Toast.LENGTH_SHORT).show();
                                }
                            }


                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });








//                    databaseReference.child("getdata").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                            if(snapshot.hasChild(phonetxt)){
//                                final String getpassword=snapshot.child(phonetxt).child("pass").getValue(String.class);
//
//                                if(getpassword.equals(passwordtxt)){
//                                    startActivity(new Intent(MainActivity.this,AfterSuccessfulLogin.class));
//                                    finish();
//                                }
//                                else {
//                                    Toast.makeText(MainActivity.this, "Password incorrect", Toast.LENGTH_SHORT).show();
//                                }
//                               }
//                            else{
//                                Toast.makeText(MainActivity.this,"enter correct mobile number",Toast.LENGTH_SHORT).show();
//                            }
//
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
                }

            }
        });

















////        buttontonextpage
//
//        Button bt2;
//        bt2=findViewById(R.id.button2);
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,NewUser.class);
//                startActivity(intent);
//            }
//        });


////                authorisation
//                auth=FirebaseAuth.getInstance();
//                signupEmail=findViewById(R.id.editTextTextEmailAddress);
//                signupPassword=findViewById(R.id.editTextTextPassword);
//                button1=findViewById(R.id.button1);
//
//                button1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        String user=signupEmail.getText().toString().trim();
//                        String pass=signupPassword.getText().toString().trim();
//
//                        if(user.isEmpty()){
//                            signupEmail.setError("Please Enter Email");
//                        }
//
//                        if(user.isEmpty()){
//                            signupPassword.setError("Please Enter Password");
//                        }
//
//                        else{
//                            auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if(task.isSuccessful()){
//                                        Toast.makeText(MainActivity.this,"signup successful",Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(MainActivity.this,AfterSuccessfulLogin.class));//
//                                    }
//                                    else{
//                                        Toast.makeText(MainActivity.this,"incorrect username or password"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                                    }
//
//                                }
//                            });
//                        }
//
//
//                    }
//                });





            }


}