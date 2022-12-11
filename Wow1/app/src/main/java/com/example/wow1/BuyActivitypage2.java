package com.example.wow1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class BuyActivitypage2 extends AppCompatActivity {

FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
FirebaseStorage firebaseStorage;
RecyclerView recyclerView;
DisplayData_Adapter displayData_adapter;
List<productUpload2> productUpList;
private TextView imgdesc;
String descp;

  @SuppressLint("MissingInflatedId")
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_activitypage2);

        databaseReference =FirebaseDatabase.getInstance().getReference("imagesdescription");
        imgdesc=findViewById(R.id.tvd);
        showUserData();



//        firebaseDatabase=FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").getDatabase();
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wow1-faccd-default-rtdb.firebaseio.com/").child("imagesdescription");
//
//       // databaseReference.getRef().child("imagesdescription");
//        firebaseStorage=FirebaseStorage.getInstance();
////        recyclerView=findViewById(R.id.displaydata);
////        recyclerView.setHasFixedSize(true);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
////
////
////        productUpList=new ArrayList<productUpload2>();
////        displayData_adapter=new DisplayData_Adapter(BuyActivitypage2.this,productUpList);
//        imgdesc = findViewById(R.id.tvd);
//
//
////    RecyclerView rv = findViewById(R.id.displaydata);
//
//
//
//
//
//        databaseReference.orderByChild("user").equalTo("black").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                //String value = snapshot.child("imagesdescription").getValue(String.class);
//                productUpload2 desc = snapshot.getValue(productUpload2.class);
//                //String s = desc.getUser();
//                imgdesc.setText(desc.getUser());
//                //imgdesc.setText("sai");
//                Toast.makeText(BuyActivitypage2.this, "updated", Toast.LENGTH_SHORT).show();
//
//               // imgdesc.setText(value);
//
//
////                if (value!=null) {
////                    imgdesc.setText(value);
////                }
////
////                Log.d("TAG", "onDataChange: hi bro "+value);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(BuyActivitypage2.this,"failed to get data",Toast.LENGTH_SHORT).show();
//            }
//        });


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










//
//    ListView listview;
//    static ArrayList<productUpload2> list;
//    Adapter adapter;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_buy_activitypage2);
//
//        listview=findViewById(R.id.listview);
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("imagesdescription");
//        list=new ArrayList<productUpload2>();
////        adapter = new DisplayData_Adapter(getApplicationContext(),list);
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                DatabaseReference mainRef=database.getReference("imagesdescription");
//                Query query = mainRef.orderByChild("user");
//                query.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                            productUpload2 desc= postSnapshot.getValue(productUpload2.class);
//
//                            String description=desc.getUser();
////                            String expr=reg.getExpr();
////
//                            list.add(new productUpload2(description));
////                            adapter.notifyDataSetChanged();
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });





















    }

    private void showUserData() {
      Intent intent =getIntent();
      descp=intent.getStringExtra("user");

      imgdesc.setText(descp);
    }
}