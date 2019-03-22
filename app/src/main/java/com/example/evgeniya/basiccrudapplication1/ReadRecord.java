package com.example.evgeniya.basiccrudapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReadRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_record);

        Button btnFetchData = findViewById(R.id.btn_get_record);
        Button btnGoToMain = findViewById(R.id.btn_back);

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputId = findViewById(R.id.read_empty_id);
                TextView viewFirst = findViewById(R.id.read_first);
                TextView viewLast = findViewById(R.id.read_last);
                TextView viewInsured = findViewById(R.id.read_insured);

                DBClass dbc = new DBClass(getApplicationContext());

                Employee e = dbc.getEmployee(Integer.valueOf(inputId.getText().toString()));

                viewFirst.setText(e.getFirstName());
                viewLast.setText(e.getLastName());
                viewInsured.setText(e.isInsured ? "Insured" : "Not Insured");
            }
        });
    }
}
