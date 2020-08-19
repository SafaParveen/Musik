package com.example.musik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class homeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        CardView c1 = (CardView)findViewById(R.id.cardView1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(homeScreen.this, songView.class));
                i.putExtra("index","one");
                startActivity(i);


            }
        });
        CardView c2 = (CardView)findViewById(R.id.cardView2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(homeScreen.this, songView.class));
                i.putExtra("index","two");
                startActivity(i);


            }
        });
        CardView c3 = (CardView)findViewById(R.id.cardView3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(homeScreen.this, songView.class));
                i.putExtra("index","three");
                startActivity(i);
            }
        });
        CardView c4 = (CardView)findViewById(R.id.cardView4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(homeScreen.this, songView.class));
                i.putExtra("index","four");
                startActivity(i);

            }
        });
        CardView c5 = (CardView)findViewById(R.id.cardView5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(homeScreen.this, songView.class));
                i.putExtra("index","five");
                startActivity(i);

            }
        });
    }


}
