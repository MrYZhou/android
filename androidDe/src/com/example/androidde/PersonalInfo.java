package com.example.androidde;

import java.util.ArrayList;

import com.example.database.UserDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalInfo extends Activity{
	Intent intent;
	String name,info;
	UserDB myDb;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_info);
		name=getIntent().getStringExtra("name");
		myDb=new UserDB(PersonalInfo.this, "user");
		ArrayList<User> list=myDb.findinfo(name);
		for(User u:list) {
			info="用户账号 ："+u.getUsername()+"\n"+
					"昵称 ："+  u.getName()+"\n"+
					"出生日期："+u.getBirthday()+"\n"+
					"家乡："+  u.getHometown()+"\n"+
					"邮箱："+  u.getEmail()+"\n";
		}
		info=info.replace("null","暂时未设置");
//		Toast.makeText(PersonalInfo.this, name,Toast.LENGTH_LONG).show();
		((TextView)findViewById(R.id.show)).setText(info);;
		
	}
	public void onClick1(View v) {
		startActivity(new Intent(PersonalInfo.this,InfoChange.class));
	}
	public void onClick2(View v) {
		startActivity(new Intent(PersonalInfo.this,MainActivity.class));
	}
}
