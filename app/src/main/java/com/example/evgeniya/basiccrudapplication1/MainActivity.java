package com.example.evgeniya.basiccrudapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bCreate = findViewById((R.id.btn_create));
        Button bRead = findViewById((R.id.btn_get));
        Button bDelete = findViewById((R.id.btn_delete));
        Button bUpdate = findViewById((R.id.btn_update));
        Button bList = findViewById((R.id.btn_list));

        bCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddRecord.class);
                startActivity(i);
            }
        });

        bRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ReadRecord.class);
                startActivity(i);
            }
        });

        bList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ListRecords.class);
                startActivity(i);
            }
        });
    }
}
