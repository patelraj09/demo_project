package com.example.demo_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    ImageView imageView;
    TextView name,description;
    String name1,description1;

    int img;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        name = findViewById(R.id.text);
        description = findViewById(R.id.description);
        imageView = findViewById(R.id.imageview);

        Intent intent = getIntent();
        name1 = intent.getStringExtra("Name");
        description1 = intent.getStringExtra("Description");
        img = intent.getIntExtra("Img",0);

        name.setText(name1);
        description.setText(description1);
        imageView.setImageResource(img);

    }
}