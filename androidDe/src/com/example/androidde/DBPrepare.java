package com.example.androidde;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPrepare extends SQLiteOpenHelper{
	private String CREATE_TABLE_SQL = "";
	private String TABLE_NAME = "";
	public DBPrepare(Context context, String dbName, int dbVersion, String tableName, String sql) {
		super(context, dbName, null, dbVersion);
		this.CREATE_TABLE_SQL=sql;
		this.TABLE_NAME=tableName;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + TABLE_NAME);
		onCreate(db);
	}


}
