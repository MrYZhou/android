package com.example.adapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	String str="编程字典";
	private String[] bianhao= {
			"（1）","（2）","（3）","（4）","（5）","（6）","（7）","（8）",
	};
	private String[] name ={  
    		"c"+str,  
    		"jav+str",  
    		"perl"+str,  
    		"javascript"+str,  
    		"html"+str,  
    		"go"+str,
    		"c++"+str,
    		"node.js"+str
     };
	
	private ListView lt1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//存取map，map又是key
		List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < name.length; i++) {
			Map<String, Object> listem = new HashMap<String, Object>();
			listem.put("name", name[i]);
			listem.put("bianhao",bianhao[i]);
			listems.add(listem);
		}
		
		/*SimpleAdapter的参数说明
		 * 第一个参数    this上下文
		 * 第二个参数    填写用于填充的集合(集合有是一个map的key-value集)
		 * 第三个参数   表示辅助布局的xml文件名
		 * 第四个参数  表示Java类中的数组名字
		 * 第五个参数  表示辅助布局的xml中的id
		 
		 * */
		SimpleAdapter simplead = new SimpleAdapter(this, listems,
				R.layout.item, new String[] { "name","bianhao"},
				new int[] {R.id.content,R.id.bianhao});
		
		lt1=(ListView)findViewById(R.id.list);
		lt1.setAdapter(simplead);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

