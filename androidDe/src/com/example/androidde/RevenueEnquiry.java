package com.example.androidde;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.example.database.RevenueDB;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker.OnDateChangedListener;

public class RevenueEnquiry extends Activity {
	private String mode = "000";
	CheckBox box1, box2, box3;
	private String[] income_source;// 对话框内容
	private DB myDb;
	private int year1,year2;
	private int month1,month2;
	private int day1,day2;
	private ArrayList<String> sources = new ArrayList<String>();// 获取数据库的收入类别
	private ArrayList<String> dates, categories, money;

	private Intent intent = new Intent();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.revenue_enquiry);
		box1 = (CheckBox) findViewById(R.id.box1);
		box2 = (CheckBox) findViewById(R.id.box2);
		box3 = (CheckBox) findViewById(R.id.box3);
		myDb = new DB(RevenueEnquiry.this, "category");
		List<Category> list = myDb.findAllCategory();

		
		//来源获取
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCategory_type().equals("1"))
				sources.add(list.get(i).getCategory_name());
		}
		income_source = sources.toArray(new String[0]);
		
		//两个日期的改变监听
		Calendar c =Calendar.getInstance();
	    year1 =c.get(Calendar.YEAR);
	    month1=c.get(Calendar.MONTH);
	    day1=c.get(Calendar.DAY_OF_MONTH);
	    year2 =c.get(Calendar.YEAR);
	    month2=c.get(Calendar.MONTH);
	    day2=c.get(Calendar.DAY_OF_MONTH);
		DatePicker datapicker = (DatePicker) findViewById(R.id.date_start);
	    datapicker.init(year1, month1, day1, new OnDateChangedListener() {
	        @Override
	        public void onDateChanged(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
				RevenueEnquiry.this.year1 = year;
				RevenueEnquiry.this.month1 = monthOfYear;
				RevenueEnquiry.this.day1 = dayOfMonth;
	        }
	      });
	    DatePicker datapicker2 = (DatePicker) findViewById(R.id.date_end);
	    datapicker.init(year2, month2, day2, new OnDateChangedListener() {
	        @Override
	        public void onDateChanged(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
				RevenueEnquiry.this.year2 = year;
				RevenueEnquiry.this.month2 = monthOfYear;
				RevenueEnquiry.this.day2 = dayOfMonth;
	        }
	      });
	    
	    
	}
		
	public void onClick1(View v) {
		// mode driven
		getcheck();

		// 获取页面的金额，日期值
	
		if(box1.isChecked()) {
			intent.putExtra("source", ((TextView)findViewById(R.id.come)).getText().toString());
		}
		
		if(box2.isChecked()) {
				int datestart = year1*365+month1*30+day1*1;
				int dateend = year2*365+month2*30+day2*1;
				
				intent.putExtra("datestart", datestart);
				intent.putExtra("dateend", dateend);
			
		}
		
		if(box3.isChecked()) {
			String ms=((EditText) findViewById(R.id.mon_start)).getText().toString();
			String me=((EditText) findViewById(R.id.mon_end)).getText().toString();
			if((ms.trim().equals("")||me.trim().equals(""))) {
				Toast.makeText(RevenueEnquiry.this, "金额条件不能为空", Toast.LENGTH_LONG).show();
				return;
			}else {
				if(Pattern.matches("\\D",ms)||Pattern.matches("\\D",me))
				{
					Toast.makeText(RevenueEnquiry.this, "非法字符,需要重新输入", Toast.LENGTH_LONG).show();
					((EditText) findViewById(R.id.mon_start)).setText("");
					((EditText) findViewById(R.id.mon_end)).setText("");
					return;
				}
				int monstart = Integer.parseInt(ms);
				int monend = Integer.parseInt(me);
				intent.putExtra("monstart", monstart);
				intent.putExtra("monend", monend);
			}	
		}
		intent.putExtra("mode", mode);
		intent.setClass(RevenueEnquiry.this, RevenueResult.class);
		startActivity(intent);
	}
	public void onClick2(View v) {
		Intent intent=new Intent(RevenueEnquiry.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	public void categoryclick(View view) {
		Builder builder = new AlertDialog.Builder(RevenueEnquiry.this);
		builder.setTitle("请选择");
		builder.setItems(income_source, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				((Button) findViewById(R.id.come)).setText(income_source[which]);
				Toast.makeText(getApplicationContext(), income_source[which], Toast.LENGTH_SHORT).show();
			}
		});
		builder.create().show();
	}

	private void getcheck() {
		if (box1.isChecked()) {
			mode = "100";
			if (box2.isChecked()) {
				mode = "110";
				if (box3.isChecked()) {
					mode = "111";
				}
			} else {
				if (box3.isChecked()) {
					mode = "101";
				} else {
					mode = "100";
				}
			}
		} else {
			if (box2.isChecked()) {
				mode = "010";
				if (box3.isChecked()) {
					mode = "011";
				}
			} else {
				if (box3.isChecked()) {
					mode = "001";
				} else {
					mode = "000";
				}
			}
		}

		
	}
}
