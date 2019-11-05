package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
public class MyReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		int level=intent.getIntExtra("level",0);//电池的电量
		listen.onListen(level+"");
		Log.i("s",level+"");
		
	} 
	public MyClickListen listen;
	
	/**
	 * @param listen the listen to set
	 */
	public void setListen(MyClickListen listen) {
		this.listen = listen;
	}
	public interface MyClickListen{
		void onListen(String level);
	}
}
