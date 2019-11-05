package com.example.database;

import java.util.ArrayList;

import com.example.androidde.DBPrepare;
import com.example.androidde.Revenue;
import com.example.androidde.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserDB {
	private static final String DATABASE_NAME="user";
    private static final int DATABASE_VERSION=1;
    private String TABLE_NAME="";
    private  String[] COLUMNS = null;
    private  String sql="";

    private DBPrepare helper;
    private SQLiteDatabase db;

    public UserDB(Context context,String tablename)
    {
    	this.TABLE_NAME=tablename;
    	
		Log.i("creat user", "yes");
		this.COLUMNS =new String[] { "id", "username", "password", "birthday","hometown","email","name"};
		sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key, "
				+ "" + COLUMNS[1] + " varchar(50)," + COLUMNS[2] + " varchar(50) ,"+COLUMNS[3] + 
				" varchar(50) ,"+COLUMNS[4] + " varchar(50) , "+COLUMNS[5] + " varchar(50)"
						+ " , "+COLUMNS[6] + " varchar(50) );";
		helper=new DBPrepare(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }
    public void insert(User data)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMNS[1], data.getUsername());
        values.put(COLUMNS[2], data.getPassword());
        db.insert("user", null, values);
    }
    public void update(User data,String args) {
    	 ContentValues values=new ContentValues();
         values.put(COLUMNS[6], data.getName());
         values.put(COLUMNS[2], data.getPassword());
         values.put(COLUMNS[3], data.getBirthday());
         values.put(COLUMNS[4], data.getHometown());
         values.put(COLUMNS[5], data.getEmail());
    	db.update(TABLE_NAME, values, "name = ?", new String[] {args});
    }
    public ArrayList<User> findinfo(String args) {
    	ArrayList<User> list=new ArrayList<User>();
    	User user=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, "username like ?", new String[]{args}, null, null, null);
        while(cursor.moveToNext())
        {
        	user=new User();
        	user.setUsername(cursor.getString(1));
        	user.setPassword(cursor.getString(2));
        	user.setBirthday(cursor.getString(3));
        	user.setHometown(cursor.getString(4));
        	user.setEmail(cursor.getString(5));
            list.add(user);
        }
        cursor.close();
        db.close();
        return list;
    }
}
