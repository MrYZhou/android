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
	 * oncreateд��Ҫ�Ĳ���Ҫ��һЩ���ԵĻ�ȡ
	 * onclicklisten���������ת�Ĵ���
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
		
		Intent intent=getIntent();//��ȡ����ҳ���putextra�Ĵ��룬�ؼ�
		String name=intent.getStringExtra("username");
		String sex=intent.getStringExtra("sex");
		String phonenum=intent.getStringExtra("phonenum");
		String spresult=intent.getStringExtra("spresult");
		String hobby=intent.getStringExtra("hobby");
		String content="�û�����"+name+"\n"+
				"�Ա�:"+sex+"\n"+
				"�绰:"+phonenum+"\n"+
				"����:"+spresult+"\n"+
				"����"+hobby;
				
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
