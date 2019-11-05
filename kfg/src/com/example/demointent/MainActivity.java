package com.example.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener{
	/**
	 * 
	 * ��Դ�Ļ�ȡ
	 * 1.�û���user
	 * 2.����pwd
	 * 3.radio sexradio
	 * 4.���� spinner
	 * 4.checkbox box1,box2,box3
	 * 5.��ť�ĵ���¼����򵥵�д�뵽���������У�����
	 * 
	 * */
	EditText user,phone,pwd;//��������
	Button btn1;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	String[] address={ "������Դ��", "���۲�", "����","������" };
	
	String spresult;
	CheckBox box1,box2,box3,box4;
	Intent intent=new Intent();
	//Bundle bundle=new Bundle();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//���id��ȡ
		btn1=(Button) findViewById(R.id.btn1);
		user=(EditText) findViewById(R.id.user);
		phone=(EditText) findViewById(R.id.phone);
		pwd = (EditText) findViewById(R.id.pwd);
		spinner=(Spinner) findViewById(R.id.spinner);
		box1 = (CheckBox) findViewById(R.id.box1);
		box2 =(CheckBox) findViewById(R.id.box2);
		box3 =(CheckBox) findViewById(R.id.box3);
		box4 =(CheckBox) findViewById(R.id.box4);
		
		btn1.setOnClickListener((OnClickListener) new myclick());//������ת
		
		user.setError("�û�������Ϊ��");
		pwd.setError("���벻��Ϊ��");
		
		//RadioGroup radioGroup = (RadioGroup) findViewById(R.id.sexradio);
		//����״̬�ı���¼�
		((RadioGroup)findViewById(R.id.sexradio)).setOnCheckedChangeListener((OnCheckedChangeListener) this);
		
		 //spinner�����ݷ�װ����ȡ����
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, address);        
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id)
            {
                spresult=parent.getItemAtPosition(pos).toString();
              Toast.makeText(MainActivity.this, spresult, Toast.LENGTH_SHORT).show();
                intent.putExtra("spresult", spresult);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {
                // TODO Auto-generated method stub
            }

        });
        		
	
	}
	
	
	//�û��͵绰�����ݷ�װ
	class myclick implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String username=user.getText().toString().trim();
		    String phonenum=phone.getText().toString().trim();
		    String password=pwd.getText().toString().trim();
			intent.setClass(MainActivity.this, sec.class);
			
		    //��ѡ��İ������ݷ�װ
	        String str="";
	        if(box1.isChecked()) {
	        	str+=box1.getText().toString()+" ";
	        }
	        if(box2.isChecked()) {
	        	str+=box2.getText().toString()+" ";
	        }
	        if(box3.isChecked()) {
	        	str+=box3.getText().toString()+" ";
	        }
	        if(box4.isChecked()) {
	        	str+=box4.getText().toString()+" ";
	        }
	        intent.putExtra("hobby", str);
	        //Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();	
	        
	        if(!username.equals("")&&!password.equals("")){
	        	intent.putExtra("username", username);
				intent.putExtra("phonenum", phonenum);
				Toast.makeText(MainActivity.this, "�ʺţ�"+username+"\n"+"���룺"+password, Toast.LENGTH_SHORT).show();
				startActivity(intent);
	        }else {
	        	if(username.equals(""))
		        	user.setError("�û�������Ϊ��");
	    		if(password.equals(""))
	    			pwd.setError("���벻��Ϊ��");
	        }
	        
		}
	}
	
	//��ѡ�����ݷ�װ
	@Override
	 public void onCheckedChanged(RadioGroup group, int checkedId) {
		 int re=group.getCheckedRadioButtonId();
		 if(re==1) {
			 intent.putExtra("sex", "��");

		 }else {
			 intent.putExtra("sex", "Ů");
			 
		 }
	 }
	 
	 //Houxu
	 public void click1(View view){
//     	box3.setTextColor(Color.rgb(255, 255, 255));
//    	box3.setTextColor(Color.parseColor("#F40"));
	 }
	 
}

