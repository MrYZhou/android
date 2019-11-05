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
	 * 资源的获取
	 * 1.用户名user
	 * 2.密码pwd
	 * 3.radio sexradio
	 * 4.部门 spinner
	 * 4.checkbox box1,box2,box3
	 * 5.按钮的点击事件被简单的写入到布局属性中，忽略
	 * 
	 * */
	EditText user,phone,pwd;//变量声明
	Button btn1;
	Spinner spinner;
	ArrayAdapter<String> adapter;
	String[] address={ "人力资源部", "销售部", "财务部","开发部" };
	
	String spresult;
	CheckBox box1,box2,box3,box4;
	Intent intent=new Intent();
	//Bundle bundle=new Bundle();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//组件id获取
		btn1=(Button) findViewById(R.id.btn1);
		user=(EditText) findViewById(R.id.user);
		phone=(EditText) findViewById(R.id.phone);
		pwd = (EditText) findViewById(R.id.pwd);
		spinner=(Spinner) findViewById(R.id.spinner);
		box1 = (CheckBox) findViewById(R.id.box1);
		box2 =(CheckBox) findViewById(R.id.box2);
		box3 =(CheckBox) findViewById(R.id.box3);
		box4 =(CheckBox) findViewById(R.id.box4);
		
		btn1.setOnClickListener((OnClickListener) new myclick());//设置跳转
		
		user.setError("用户名不能为空");
		pwd.setError("密码不能为空");
		
		//RadioGroup radioGroup = (RadioGroup) findViewById(R.id.sexradio);
		//设置状态改变的事件
		((RadioGroup)findViewById(R.id.sexradio)).setOnCheckedChangeListener((OnCheckedChangeListener) this);
		
		 //spinner的数据封装，获取部门
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
	
	
	//用户和电话的数据封装
	class myclick implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String username=user.getText().toString().trim();
		    String phonenum=phone.getText().toString().trim();
		    String password=pwd.getText().toString().trim();
			intent.setClass(MainActivity.this, sec.class);
			
		    //多选框的爱好数据封装
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
				Toast.makeText(MainActivity.this, "帐号："+username+"\n"+"密码："+password, Toast.LENGTH_SHORT).show();
				startActivity(intent);
	        }else {
	        	if(username.equals(""))
		        	user.setError("用户名不能为空");
	    		if(password.equals(""))
	    			pwd.setError("密码不能为空");
	        }
	        
		}
	}
	
	//单选的数据封装
	@Override
	 public void onCheckedChanged(RadioGroup group, int checkedId) {
		 int re=group.getCheckedRadioButtonId();
		 if(re==1) {
			 intent.putExtra("sex", "男");

		 }else {
			 intent.putExtra("sex", "女");
			 
		 }
	 }
	 
	 //Houxu
	 public void click1(View view){
//     	box3.setTextColor(Color.rgb(255, 255, 255));
//    	box3.setTextColor(Color.parseColor("#F40"));
	 }
	 
}

