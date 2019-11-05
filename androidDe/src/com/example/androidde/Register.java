package com.example.androidde;

import com.example.database.UserDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity{
	private EditText etNumber;
	private EditText etPassword;
	private UserDB myDb;
	private User user;
//	private CheckBox cbRemember;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
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
		myDb=new UserDB(Register.this,"user");
		user=new User();
		user.setUsername(number);
		user.setPassword(password);
		myDb.insert(user);
		// 注册成功
		Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
		
		//成功注册需要跳登录页面
		startActivity(new Intent(Register.this,UserRL.class));
	}
	
}
