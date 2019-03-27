package com.example.evgeniya.basiccrudapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListRecords extends AppCompatActivity {
    EmployeeAdapter empAdapter;

    private List<Employee> empList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_records);

        RecyclerView recycle = findViewById(R.id.recycler);
        empAdapter = new EmployeeAdapter(empList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(layoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());

        // OPTIONAL
        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        DBClass db = new DBClass(this);
        empList.addAll(db.getEmployees());

        recycle.setAdapter(empAdapter);
    }
}
