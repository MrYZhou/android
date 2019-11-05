package com.example.androidde;


import java.util.ArrayList;
import java.util.List;

import com.example.database.RevenueDB;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class CategoryManagement extends Activity{
	private int type;
	private String category_name,category_detail;
	private String[] listview_data= {};
	private DB myDb;
	private ArrayList<String> data_revenue,data_expenditure;
	//private List<Category> listview_revenue=new ArrayList<Category>(),listview_expenditure=new ArrayList<Category>();
	private List<Category> list=new ArrayList<Category>();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.id.category);
		
		((RadioGroup)findViewById(R.id.category_type)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
				myDb=new DB(CategoryManagement.this, "category");
				type=group.getCheckedRadioButtonId()==1?1:2;
//				if(group.getCheckedRadioButtonId()==0)type=0;
				Toast.makeText(CategoryManagement.this, type+"", Toast.LENGTH_SHORT).show();
				list = myDb.findAllCategory();
				data_expenditure=new ArrayList<String>();
				data_revenue=new ArrayList<String>();
				if(list!=null&&list.size()>0) {
					for(Category c:list) {
						category_name=c.getCategory_name();
						category_detail=c.getCategory_detail();
						//Toast.makeText(CategoryManagement.this, c.getCategory_type()+"", Toast.LENGTH_SHORT).show();
						if(c.getCategory_type().trim().equals("1")) {
							data_revenue.add(category_name+"\t"+category_detail);
						}
						else if(c.getCategory_type().trim().equals("2")){
							data_expenditure.add(category_name+"\t"+category_detail);
						}else {
							
						}
					}
				}
				
				
				if(type==2) {
					//查询支出，type2的数据，数据库，记录type=2
				    ((ListView)findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(CategoryManagement.this,android.R.layout.simple_list_item_1,data_expenditure));
				}else if(type==1) {
//					//查询收入，type1的数据, 数据库，记录type=1

					((ListView)findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(CategoryManagement.this, android.R.layout.simple_list_item_1,data_revenue));
				}
				//((ListView)findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(CategoryManagement.this, android.R.layout.simple_list_item_1,data_revenue));
			}
		});
		
	}
	public void onClick1(View v) {
		//数据-->数据库，需要数据库，数据
		
		//数据库对象
		DB myDb2 = new DB(CategoryManagement.this, "category");
		
		//insert 对象
		String name=((EditText) findViewById(R.id.category_name)).getText().toString();
		String detail=((EditText) findViewById(R.id.category_introduce)).getText().toString();
		if(type==0) {
			Toast.makeText(CategoryManagement.this, "选择一个类别", Toast.LENGTH_SHORT).show();return;
		}
		myDb2.insert( new Category(name,detail,String.valueOf(type)) );
		Toast.makeText(CategoryManagement.this, name+","+detail+"!", Toast.LENGTH_SHORT).show();
	}

	
	public void onClick3(View v) {
		Intent intent=new Intent(CategoryManagement.this, MainActivity.class);
		startActivity(intent);
	}
}
