package com.example.broadcast;

import com.example.broadcast.MyReceiver.MyClickListen;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements MyClickListen {
	MyReceiver myReceiver;
	private TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview = (TextView) findViewById(R.id.textview);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		myReceiver = new MyReceiver();
		registerReceiver(myReceiver, intentFilter);
		myReceiver.setListen(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(myReceiver);
	}

	// 通过回调，得到BroadcastReceiver中的电量使用情况，并且设置给textview;
	@Override
	public void onListen(String level) {
		Log.i("resilt---------------",level);
		textview.setText(level + "%");
		boolean result= Integer.parseInt(level)<15?true:false;
		if(result) {
			Toast.makeText(this, "电量为"+level+"%,不足15%", 100).show();
		}else {
			Toast.makeText(this, "电量为"+level+"%", 100).show();
		}
	}
}
