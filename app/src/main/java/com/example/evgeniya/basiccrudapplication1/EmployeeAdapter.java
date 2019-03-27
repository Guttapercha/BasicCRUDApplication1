package com.example.evgeniya.basiccrudapplication1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>{

    List<Employee> employeelist;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView displayId, displayFirst, displayLast;
        ToggleButton toggleInsured;

        MyViewHolder (View view) {
            super(view);

            displayId = view.findViewById(R.id.display_id);
            displayFirst = view.findViewById(R.id.display_first);
            displayLast = view.findViewById(R.id.display_last);
            toggleInsured = view.findViewById(R.id.toggle_insured);
        }
    }

    EmployeeAdapter(List<Employee> employeelist) {
        this.employeelist = employeelist;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emprow, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return this.employeelist.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int i) {
        final Employee employee = employeelist.get(i);

        viewHolder.displayId.setText(String.valueOf(employee.getId()));
        viewHolder.displayFirst.setText(employee.getFirstName());
        viewHolder.displayLast.setText(employee.getLastName());
        viewHolder.toggleInsured.setChecked(employee.isInsured());
    }
}

