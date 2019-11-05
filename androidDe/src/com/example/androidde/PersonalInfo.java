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
			info="�û��˺� ��"+u.getUsername()+"\n"+
					"�ǳ� ��"+  u.getName()+"\n"+
					"�������ڣ�"+u.getBirthday()+"\n"+
					"���磺"+  u.getHometown()+"\n"+
					"���䣺"+  u.getEmail()+"\n";
		}
		info=info.replace("null","��ʱδ����");
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
