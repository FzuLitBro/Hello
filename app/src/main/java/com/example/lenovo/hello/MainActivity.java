package com.example.lenovo.hello;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private FruitAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SendActivity.class);
                startActivityForResult(intent, 1);
                break;
            default:
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(MainActivity.this, fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", "A");
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", "A");
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", "A");
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", "A");
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", "A");
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", "A");
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", "A");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", "A");
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", "A");
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", "A");
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String fruitName = data.getStringExtra("fruit_name");
                    String fruitMessage = data.getStringExtra("fruit_message");
                    Fruit fruit = new Fruit(fruitName, fruitMessage);
                    fruitList.add(fruit);
                }
                break;
            default:
        }
    }

    @Override
    protected void onResume() {
        adapter.notifyDataSetChanged();
        super.onResume();
    }
}

