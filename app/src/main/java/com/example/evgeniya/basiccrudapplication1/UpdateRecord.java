package com.example.evgeniya.basiccrudapplication1;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class UpdateRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnGoToMain = findViewById(R.id.btn_back3);

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBClass dbc = new DBClass(getApplicationContext());

                EditText editId = findViewById(R.id.emp_id_to_update);
                EditText editFirst = findViewById(R.id.empfn_to_update);
                EditText editLast = findViewById(R.id.empln_to_update);
                ToggleButton toggleIns = findViewById(R.id.toggleButton2);

                Integer empId = Integer.valueOf(editId.getText().toString());

                dbc.updateEmployee(empId, editFirst.toString(), editLast.toString(), toggleIns.isChecked());

                Toast.makeText(getApplicationContext(), "Record updated!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
