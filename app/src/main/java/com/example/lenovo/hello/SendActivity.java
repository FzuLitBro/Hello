package com.example.lenovo.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SendActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        Button button1 = (Button) findViewById(R.id.button);
        final EditText edit1 = (EditText) findViewById(R.id.edit_text1);
        final EditText edit2 = (EditText) findViewById(R.id.edit_text2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String str1 = edit1.getText().toString();
                String str2 = edit2.getText().toString();
                intent.putExtra("fruit_name", str1);
                intent.putExtra("fruit_message", str2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
