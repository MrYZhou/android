package com.example.androidde;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.database.RevenueDB;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.Toast;

public class RevenueManagement extends Activity{
	Intent intent=new Intent();
	private String[] income_source;//对话框内容
	private String income;//最终选择
	private String income_num="";
	private String remarks="";
	private String date="";
	private DB myDb;
	private RevenueDB myDb2;
	private int year;
	private int month;
	private int day;
	private ArrayList<String> sources=new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.revenue_management);
		//从类别表读取来源列表
		 myDb=new DB(RevenueManagement.this, "category");
		List<Category> list=myDb.findAllCategory();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCategory_type().equals("1"))
			sources.add(list.get(i).getCategory_name());
		}
		income_source = sources.toArray(new String[0]);
		myDb2=new RevenueDB(RevenueManagement.this,"revenue");//更换数据库
		
		DatePicker datapicker = (DatePicker) findViewById(R.id.date);
		Calendar c =Calendar.getInstance();
	    year =c.get(Calendar.YEAR);
	    month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    datapicker.init(year, month, day, new OnDateChangedListener() {
	        @Override
	        public void onDateChanged(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
				RevenueManagement.this.year = year;
				RevenueManagement.this.month = monthOfYear;
				RevenueManagement.this.day = dayOfMonth;
				
	        }
	      });
	}
	//来源监听

    public void categoryclick(View view)
    {
        Builder builder=new AlertDialog.Builder(RevenueManagement.this);
        builder.setTitle("请选择");
        builder.setItems(income_source, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
            	
            	((Button)findViewById(R.id.come)).setText( income_source[which]);
                Toast.makeText(getApplicationContext(), income_source[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
	    
	public void onClick1(View v) {
		//数据库添加
		//数据
		this.date=year+"-"+month+"-"+day;
		this.income=((Button)findViewById(R.id.come)).getText().toString().trim();
		this.income_num=((EditText)findViewById(R.id.income)).getText().toString().trim();
		this.remarks=((EditText)findViewById(R.id.remarks)).getText().toString().trim();
		myDb2=new RevenueDB(RevenueManagement.this,"revenue");
		Revenue revenue=new Revenue();
		revenue.setIncome_num(income_num);
		revenue.setIncome_source(income);
		revenue.setRemarks(remarks);
		revenue.setDate(date);
		myDb2.insert(revenue);
//		Toast.makeText(RevenueManagement.this, "添加记录成功", Toast.LENGTH_SHORT).show();
		Toast.makeText(RevenueManagement.this, "添加成功", Toast.LENGTH_SHORT).show();
	}
	public void onClick2(View v) {
		Intent intent=new Intent(RevenueManagement.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
