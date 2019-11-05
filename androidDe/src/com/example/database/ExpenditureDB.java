package com.example.database;

import java.util.ArrayList;

import com.example.androidde.DBPrepare;
import com.example.androidde.Expenditure;
import com.example.androidde.Revenue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ExpenditureDB {
	private static final String DATABASE_NAME="expenditure";
    private static final int DATABASE_VERSION=1;
    private String TABLE_NAME="";
    private  String[] COLUMNS = null;
    private  String sql="";

    private DBPrepare helper;
    private SQLiteDatabase db;

    public ExpenditureDB(Context context,String tablename)
    {
    	this.TABLE_NAME=tablename;
    	
		Log.i("creat Expenditure", "yes");
		this.COLUMNS =new String[] { "id", "outcome_source", "outcome_num", "remarks","date"};
		sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] + " varchar(50) ,"+COLUMNS[3] + " varchar(50) ,"+COLUMNS[4] + " varchar(50) );";
		helper=new DBPrepare(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }
    public void insert(Expenditure data)
    {
        ContentValues values=new ContentValues();
       // values.put(COLUMNS[0], data.getId());
        values.put(COLUMNS[1], data.getOutcome_source());
        values.put(COLUMNS[2], data.getOutcome_num());
        values.put(COLUMNS[3], data.getRemarks());
        values.put(COLUMNS[4], data.getDate());
        db.insert(TABLE_NAME, null, values);
        
    }
    public ArrayList<Expenditure> findAllExpenditure()
    {
        ArrayList<Expenditure> list=new ArrayList<Expenditure>();
        Expenditure expenditure=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
        	expenditure=new Expenditure();
        	expenditure.setOutcome_source(cursor.getString(1));
        	expenditure.setOutcome_num(cursor.getString(2));
        	expenditure.setRemarks(cursor.getString(3));
        	expenditure.setDate(cursor.getString(4));
            list.add(expenditure);
        }
        cursor.close();
        return list;
    }
    
    
}
