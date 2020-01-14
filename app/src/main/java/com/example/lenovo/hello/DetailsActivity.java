package com.example.lenovo.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DetailsActivity extends AppCompatActivity {
    static TextView textview1;
    static TextView textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        textview1 = (TextView) findViewById(R.id.text1);
        textview2 = (TextView) findViewById(R.id.text2);
        Intent intent = getIntent();
        textview1.setText(intent.getExtras().getString("param1"));
        textview2.setText(intent.getExtras().getString("param2"));
    }

    public static void actionStart(Context context, String name, String message) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("param1", name);
        intent.putExtra("param2", message);
        context.startActivity(intent);

    }

}
