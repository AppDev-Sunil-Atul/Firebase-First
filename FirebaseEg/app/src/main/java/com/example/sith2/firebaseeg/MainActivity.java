package com.example.sith2.firebaseeg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    Button post;

    TextView names;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         name= (EditText) findViewById(R.id.name);
         age= (EditText) findViewById(R.id.age);
         post= (Button) findViewById(R.id.post);

        names= (TextView) findViewById(R.id.data);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("user");


        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1=name.getText().toString();
                String age1=age.getText().toString();

                databaseReference=firebaseDatabase.getReference().child("user").push();
                databaseReference.child("name").setValue(name1);
                databaseReference.child("age").setValue(age1);

            }
        });

        fech();





    }

    private void fech() {
        databaseReference.orderByChild("name").equalTo("ud").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("data", "onDataChange: "+dataSnapshot.toString());

              String key=dataSnapshot.getRef().getKey();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    User user=dataSnapshot1.getValue(User.class);
                    String age=user.getAge().toString();
                    names.append(age +"\n");



                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
