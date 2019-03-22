package com.example.evgeniya.basiccrudapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        Button btnAdd = findViewById(R.id.btn_save);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBClass dbc = new DBClass(getApplicationContext());

                EditText editId = findViewById(R.id.id);
                EditText editFirst = findViewById(R.id.first_name);
                EditText editLast = findViewById(R.id.last_name);
                ToggleButton toggleIns = findViewById(R.id.toggleButton);

                Employee newEmp = new Employee(Integer.valueOf(editId.getText().toString()),
                        editFirst.getText().toString(),
                        editLast.getText().toString(),
                        toggleIns.isChecked());

                dbc.addEmployee(newEmp);

                Toast.makeText(getApplicationContext(), "Record added!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
