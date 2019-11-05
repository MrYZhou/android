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
		//���Ҳ���ȥƥ��
		myDb=new UserDB(UserRL.this,"user");
//		User user=new User();
		ArrayList<User> user=new ArrayList<>();
		user=myDb.findinfo(number);
		if(user.size()>0) {
			for(User u:user) {
				if(u.getPassword().equals(password)) {
					// ��¼�ɹ�
					Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent(UserRL.this,MainActivity.class);
					intent.putExtra("name", number);
					startActivity(intent);
				}else {
					Toast.makeText(this, "�������", Toast.LENGTH_SHORT).show();
				}
			}
		}else {
			Toast.makeText(this, "�޴��û�", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public void onClick2(View v) {
		//����ע�����ת
		startActivity(new Intent(UserRL.this,Register.class));
		
	}
}
