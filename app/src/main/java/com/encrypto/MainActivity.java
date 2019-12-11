package com.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEncrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = "encrypt";
                callNextActivity(action);
            }
        });

        findViewById(R.id.btnDecrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = "decrypt";
                callNextActivity(action);
            }
        });
    }

    private void callNextActivity(String action){
        Intent intent = new Intent(this,EncryptDecrypt.class);
        intent.putExtra("action",action);
        startActivity(intent);
    }

}
