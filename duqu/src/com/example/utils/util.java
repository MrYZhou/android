package com.example.utils;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class util {
	
	public static boolean saveUserInfo(Context context, String msg) {
		SharedPreferences sp = context.getSharedPreferences("data",
				Context.MODE_PRIVATE);
		Editor edit = sp.edit();//获取编辑框的属性
		edit.putString("msg", msg);
		edit.commit();
		return true;
	}

	public static Map<String, String> getUserInfo(Context context) {
		SharedPreferences sp = context.getSharedPreferences("data",
				Context.MODE_PRIVATE);
		String msg = sp.getString("msg", null);
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("msg", msg);
		return userMap;
	}
}
