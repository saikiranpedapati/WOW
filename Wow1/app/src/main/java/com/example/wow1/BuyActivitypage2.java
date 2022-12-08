package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuyActivitypage2 extends AppCompatActivity {

FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
FirebaseStorage firebaseStorage;
RecyclerView recyclerView;
DisplayData_Adapter displayData_adapter;
List<productUpload2> productUpList;
private TextView imgdesc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_activitypage2);



//        firebaseDatabase=FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").getDatabase();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("imagesdescription");

        databaseReference.getRef().child("imagesdescription");
        firebaseStorage=FirebaseStorage.getInstance();
//        recyclerView=findViewById(R.id.displaydata);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        productUpList=new ArrayList<productUpload2>();
//        displayData_adapter=new DisplayData_Adapter(BuyActivitypage2.this,productUpList);
        imgdesc = findViewById(R.id.tvd);


    RecyclerView rv = findViewById(R.id.displaydata);





        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child("imagesdescription").getValue(String.class);
                imgdesc.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BuyActivitypage2.this,"failed to get data",Toast.LENGTH_SHORT).show();
            }
        });


//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                productUpload2 productUpload2=snapshot.getValue();
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });





    }
}