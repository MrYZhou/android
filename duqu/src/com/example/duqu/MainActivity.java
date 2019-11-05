package com.example.duqu;

import java.io.File;
import java.util.Map;

import com.example.utils.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private EditText information;
//	private CheckBox cbRemember;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		information = (EditText) findViewById(R.id.information);
		
		
	}
	
	

	public void onClick1(View v) {
		String msg = information.getText().toString().trim();
		if(TextUtils.isEmpty(msg)) {}
		boolean isSaveSuccess = util.saveUserInfo(this,msg);
		if(isSaveSuccess) {
			Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
		}
	}

	
	public void onClick2(View v) {
		// TODO Auto-generated method stub
		Map<String, String> content = util.getUserInfo(this);
		SharedPreferences sp = this.getSharedPreferences("data",Context.MODE_PRIVATE);
		
		
		
		//String msg=content.get("msg");
		 //File file= new File("/data/data/"+getPackageName().toString()+"/shared_prefs","data.xml");
	     if(content==null)
	     {
	    	 Toast.makeText(this, "消息为空，不能读取", Toast.LENGTH_SHORT).show();
	    	 return;
	     }
			information.setText(sp.getString("msg", null));
			Toast.makeText(this, "读取成功", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}

