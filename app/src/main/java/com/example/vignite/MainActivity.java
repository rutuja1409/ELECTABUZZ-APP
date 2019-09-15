package com.example.vignite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button b_weekly;
    private Button b_daily;
    private SeekBar s_intensity;
    private TextView txtIntensity;
    private Button b_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_intensity= (SeekBar) findViewById(R.id.seekBar) ;

        s_intensity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                txtIntensity=(TextView) findViewById(R.id.txt_intensity);
                txtIntensity.setText(""+i+" % ");
                myRef.setValue(i+" % ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        b_weekly= (Button)findViewById(R.id.button2);
        b_weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_weekly= new Intent(MainActivity.this,weekly.class);
                startActivity(i_weekly);
                // Write a message to the database
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//
//                myRef.setValue("Hello, World!");
            }
        });



        b_daily= (Button)findViewById(R.id.button);
        b_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_daily= new Intent(MainActivity.this,daily.class);
                startActivity(i_daily);
            }
        });

        b_about= (Button)findViewById(R.id.button3);
        b_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_about= new Intent(MainActivity.this,aboutelectabuzz.class);
                startActivity(i_about);
            }
        });
    }
}
