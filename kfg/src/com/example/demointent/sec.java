package com.example.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sec extends Activity {
	/**
	 * oncreate写主要的布局要的一些属性的获取
	 * onclicklisten里面进行跳转的代码
	 * 
	 * */
	Button btn;
	TextView showzone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sec);
		
		btn=(Button) findViewById(R.id.comeback);
		btn.setOnClickListener(new myclick());
	
		showzone=(TextView) findViewById(R.id.show);
		
		Intent intent=getIntent();//获取在主页面的putextra的代码，关键
		String name=intent.getStringExtra("username");
		String sex=intent.getStringExtra("sex");
		String phonenum=intent.getStringExtra("phonenum");
		String spresult=intent.getStringExtra("spresult");
		String hobby=intent.getStringExtra("hobby");
		String content="用户名："+name+"\n"+
				"性别:"+sex+"\n"+
				"电话:"+phonenum+"\n"+
				"部门:"+spresult+"\n"+
				"爱好"+hobby;
				
		showzone.setText(content);
	}
	
	class myclick implements OnClickListener{
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent =new Intent();
			intent.setClass(sec.this, MainActivity.class);
			startActivity(intent);
			
		}
	}
}
