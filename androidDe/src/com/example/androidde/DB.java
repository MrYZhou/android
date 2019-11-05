package com.example.androidde;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DB {
	private static final String DATABASE_NAME="lar";
    private static final int DATABASE_VERSION=1;
    private String TABLE_NAME="";
    private  String[] COLUMNS = null;
    private  String sql="";

    private DBPrepare helper;
    private SQLiteDatabase db;

    public DB(Context context,String tablename)
    {
    	this.TABLE_NAME=tablename;
    	
    	if(tablename=="expenditure") {
    				
    	}
    	else if(tablename.trim().equals("revenue")){
    		Log.i("creat revenue", "yes");
    		this.COLUMNS =new String[] { "id", "income_source", "income_num", "remarks","date"};
    		DB.this.sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] + " varchar(50) ,"+COLUMNS[3] + " varchar(50) ,"+COLUMNS[4] + " varchar(50) );";
    		
    	}else if(tablename.trim().equals("category")){
    		Log.i("creat category", "yes");
    		this.COLUMNS =new String[] { "id", "category_name", "category_detail", "category_type"};
    		DB.this.sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] + " varchar(50) ,"+COLUMNS[3] + " varchar(50) );";
    	}
//        helper=new DBPrepare(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
    	DB.this.helper=new DBPrepare(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }

    public void insert(Category data)
    {
        ContentValues values=new ContentValues();
       // values.put(COLUMNS[0], data.getId());
        values.put(COLUMNS[1], data.getCategory_name());
        values.put(COLUMNS[2], data.getCategory_detail());
        values.put(COLUMNS[3], data.getCategory_type());
        db.insert(TABLE_NAME, null, values);
    }
    
    
    public ArrayList<Category> findAllCategory()
    {
        ArrayList<Category> list=new ArrayList<Category>();
        Category category=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
        	category=new Category();
            category.setCategory_name(cursor.getString(1));
            category.setCategory_detail(cursor.getString(2));
            category.setCategory_type(cursor.getString(3));
            list.add(category);
        }
        cursor.close();
        return list;
    }
   

    
    
}
