package com.example.evgeniya.basiccrudapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class DeleteRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);

        Button btnDelete = findViewById(R.id.btn_delete);

        Button btnGoToMain = findViewById(R.id.btn_back2);

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBClass dbc = new DBClass(getApplicationContext());

                EditText editId = findViewById(R.id.id_to_delete);

                Integer empId = Integer.valueOf(editId.getText().toString());

                dbc.deleteEmployee(empId);

                Toast.makeText(getApplicationContext(), "Record deleted!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
