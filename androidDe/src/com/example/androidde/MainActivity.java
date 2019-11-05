package com.example.androidde;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	Intent myintent;
	String name;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myintent = new Intent();
		name=getIntent().getStringExtra("name");
//		Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
		myintent.putExtra("name", name);
	}

	public void onClick1(View v) {
		myintent.setClass(MainActivity.this, RevenueManagement.class);
		startActivity(myintent);
	}

	public void onClick2(View v) {
		myintent.setClass(MainActivity.this, ExpenditureManagement.class);
		startActivity(myintent);
	}

	public void onClick3(View v) {
		myintent.setClass(MainActivity.this, CategoryManagement.class);
		startActivity(myintent);
	}

	public void onClick4(View v) {
		myintent.setClass(MainActivity.this, RevenueEnquiry.class);
		startActivity(myintent);
	}

	public void onClick5(View v) {
		myintent.setClass(MainActivity.this, ExpenditureEnquiry.class);
		startActivity(myintent);
	}

	public void onClick6(View v) {
		myintent.setClass(MainActivity.this, StatisticalInformation.class);
		startActivity(myintent);
	}

	public void onClick7(View v) {
		myintent.setClass(MainActivity.this, StatisticalInformation.class);
		startActivity(myintent);
	}

	public void onClick8(View v) {
		myintent.setClass(MainActivity.this, PersonalInfo.class);
		startActivity(myintent);
	}

	public void onClick9(View v) {
		
		exit();
	}
	/**ÍË³ö³ÌÐò**/
	protected void exit() {
	    Intent startMain = new Intent(Intent.ACTION_MAIN);
	    startMain.addCategory(Intent.CATEGORY_HOME);
	    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(startMain);
	    System.exit(0);
	}

}
