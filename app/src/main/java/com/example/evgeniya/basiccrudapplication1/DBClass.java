package com.example.evgeniya.basiccrudapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBClass extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;

    public DBClass(Context context) {
        super(context, Employee.TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Employee.CREATE_TABLE);
    }

    public  Employee addEmployee (Employee e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Employee.COLUMN_ID, e.getId());
        values.put(Employee.COLUMN_FIRSTNAME, e.getFirstName());
        values.put(Employee.COLUMN_LASTNAME, e.getLastName());
        values.put(Employee.COLUMN_INSURED, e.isInsured ? 1 : 0);

        db.insert(Employee.TABLE_NAME, null, values);

        return e;
    }

    public  Employee getEmployee (int empId) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Employee.TABLE_NAME,
                new String[]{Employee.COLUMN_ID, Employee.COLUMN_FIRSTNAME,
                        Employee.COLUMN_LASTNAME, Employee.COLUMN_INSURED},
                Employee.COLUMN_ID + "=?",
                new String[]{String.valueOf(empId)}, null, null, null);

        if (c != null)
            c.moveToFirst();

        Employee foundEmployee = new Employee ();
        foundEmployee.id = c.getInt(c.getColumnIndex(Employee.COLUMN_ID));
        foundEmployee.firstName = c.getString(c.getColumnIndex(Employee.COLUMN_FIRSTNAME));
        foundEmployee.lastName = c.getString(c.getColumnIndex(Employee.COLUMN_LASTNAME));
        foundEmployee.isInsured = c.getInt(c.getColumnIndex(Employee.COLUMN_INSURED)) !=0 ;

        return foundEmployee;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
