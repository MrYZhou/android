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
		// �������¼ʱ,��ȡQQ���� ������
		String number = etNumber.getText().toString().trim();
		String password = etPassword.getText().toString();
		// У�����������Ƿ���ȷ
		if(TextUtils.isEmpty(number)) {
			Toast.makeText(this, "�������˺�", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(password)) {
			Toast.makeText(this, "����������", Toast.LENGTH_SHORT).show();
			return;
		}
		myDb=new UserDB(Register.this,"user");
		user=new User();
		user.setUsername(number);
		user.setPassword(password);
		myDb.insert(user);
		// ע��ɹ�
		Toast.makeText(this, "ע��ɹ�", Toast.LENGTH_SHORT).show();
		
		//�ɹ�ע����Ҫ����¼ҳ��
		startActivity(new Intent(Register.this,UserRL.class));
	}
	
}
