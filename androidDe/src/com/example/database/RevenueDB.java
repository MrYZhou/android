package com.example.database;

import java.util.ArrayList;

import com.example.androidde.Category;
import com.example.androidde.DB;
import com.example.androidde.DBPrepare;
import com.example.androidde.Revenue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RevenueDB {
	private static final String DATABASE_NAME="revenue";
    private static final int DATABASE_VERSION=1;
    private String TABLE_NAME="";
    private  String[] COLUMNS = null;
    private  String sql="";

    private DBPrepare helper;
    private SQLiteDatabase db;

    public RevenueDB(Context context,String tablename)
    {
    	this.TABLE_NAME=tablename;
    	
		Log.i("creat revenue", "yes");
		this.COLUMNS =new String[] { "id", "income_source", "income_num", "remarks","date"};
		sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] + " varchar(50) ,"+COLUMNS[3] + " varchar(50) ,"+COLUMNS[4] + " varchar(50) );";
		helper=new DBPrepare(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }
    public void insert(Revenue data)
    {
        ContentValues values=new ContentValues();
       // values.put(COLUMNS[0], data.getId());
        values.put(COLUMNS[1], data.getIncome_source());
        values.put(COLUMNS[2], data.getIncome_num());
        values.put(COLUMNS[3], data.getRemarks());
        values.put(COLUMNS[4], data.getDate());
        db.insert("revenue", null, values);
    }
    public ArrayList<Revenue> findAllRevenue()
    {
        ArrayList<Revenue> list=new ArrayList<Revenue>();
        Revenue revenue=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
        	revenue=new Revenue();
        	revenue.setIncome_source(cursor.getString(1));
        	revenue.setIncome_num(cursor.getString(2));
        	revenue.setRemarks(cursor.getString(3));
        	revenue.setDate(cursor.getString(4));
            list.add(revenue);
        }
        cursor.close();
        db.close();
        return list;
    }
}
