package com.example.vignite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class daily extends AppCompatActivity {

    private TextView text,text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        text=(TextView) findViewById(R.id.textView2);
        text1=(TextView) findViewById(R.id.txt_current);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Value");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                String value1= value + " V";
                text.setText(value1);
                float ta= Float.parseFloat(value);
                ta= (float) (ta/5);
                String TA= String.valueOf(ta) + " A";
                text1.setText(TA);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                text.setText("Failed");

            }
        });
    }
}
