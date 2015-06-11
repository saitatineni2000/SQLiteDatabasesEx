package com.example.saisandeep.sqlitedatabasesex;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by saisandeep on 3/19/2015.
 */
public class SandeepHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="sandeepdatabase";
    private static final String TABLE_NAME="DEEPUTABLE";
    private static final int DATABASE_VERSION=2;
    private static final String UID="_id";
    private static final String NAME="Name";
    private Context context;

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME+";";


    public SandeepHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Toast.makeText(context,"constructor was called ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE DEEPUTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255));
        //String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";

        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"onCreate was called ", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){

            Toast.makeText(context," "+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       try {
           Toast.makeText(context,"Onupgrade was called ", Toast.LENGTH_SHORT).show();

           db.execSQL(DROP_TABLE);
        onCreate(db);
       }
       catch (SQLException e){

           Toast.makeText(context," "+e, Toast.LENGTH_SHORT).show();
       }



    }
}
