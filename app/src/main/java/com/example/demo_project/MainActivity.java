package com.example.demo_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<model> list;
    Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();

        list.add(new model("Burger","Savor a perfect bite with our Angus bacon chedder Burger",R.drawable.burger));
        list.add(new model("Coffee","Experience pure bliss in every sip with our Frothy Coffee Delight",R.drawable.coffee));
        list.add(new model("Frenky","Frankly, Frenky's Favorite: A Flavorful Feast!",R.drawable.frenky));
        list.add(new model("Ice Cream","Dive into pure bliss with our heavenly Ice Cream Extravaganza",R.drawable.ice_cream));
        list.add(new model("Pizza","Indulge in pizza perfection with our mouthwatering blend of premium ingredients and artisanal crust",R.drawable.pizza));

        adapter = new adapter(MainActivity.this,list);
        listView.setAdapter((ListAdapter) adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, Description.class);
                intent.putExtra("Name",list.get(position).name);
                intent.putExtra("Description",list.get(position).description);
                intent.putExtra("Img",list.get(position).img);
                startActivity(intent);
            }
        });
    }
}