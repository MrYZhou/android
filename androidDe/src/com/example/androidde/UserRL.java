package com.example.androidde;

import java.util.ArrayList;

import com.example.database.UserDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserRL extends Activity{
	private EditText etNumber;
	private EditText etPassword;
	private UserDB myDb;
//	private CheckBox cbRemember;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_zhuce);
		initView();
	}
	
	private void initView() {
		etNumber = (EditText) findViewById(R.id.et_number);
		etPassword = (EditText) findViewById(R.id.et_password);
	}

	public void onClick1(View v) {
		// 当点击登录时,获取QQ号码 和密码
		String number = etNumber.getText().toString().trim();
		String password = etPassword.getText().toString();
		// 校验号码和密码是否正确
		if(TextUtils.isEmpty(number)) {
			Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(password)) {
			Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
			return;
		}
		//查找并且去匹配
		myDb=new UserDB(UserRL.this,"user");
//		User user=new User();
		ArrayList<User> user=new ArrayList<>();
		user=myDb.findinfo(number);
		if(user.size()>0) {
			for(User u:user) {
				if(u.getPassword().equals(password)) {
					// 登录成功
					Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent(UserRL.this,MainActivity.class);
					intent.putExtra("name", number);
					startActivity(intent);
				}else {
					Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
				}
			}
		}else {
			Toast.makeText(this, "无此用户", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public void onClick2(View v) {
		//进行注册的跳转
		startActivity(new Intent(UserRL.this,Register.class));
		
	}
}
