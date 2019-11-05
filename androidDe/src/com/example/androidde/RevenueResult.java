package com.example.androidde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.database.RevenueDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class RevenueResult extends Activity{
	
	String date[],category[],money[];
	private RevenueDB myDb2;
	private List<Revenue> list2;
	private ArrayList<String> dates,categories,it_money;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.revenue_result);
		dates=new ArrayList<>();
		categories=new ArrayList<>();
		it_money=new ArrayList<>();
		
		Intent intent=getIntent();
		String mode=intent.getStringExtra("mode");
		String source=intent.getStringExtra("source");
		int	monstart=intent.getIntExtra("monstart",0);
		int monend=intent.getIntExtra("monend",0);
		int	datestart=intent.getIntExtra("datestart",0);
		int dateend=intent.getIntExtra("dateend",0);
		myDb2=new RevenueDB(RevenueResult.this,"revenue");
		list2=myDb2.findAllRevenue();
//		Toast.makeText(this,source, Toast.LENGTH_LONG).show();
		switch (mode) {
		case "000":
			//查询所有的,yes
			for(Revenue r:list2) {
				getlist(r);
			}
			toArr();
			break;
		case "001":
			//查询所有的，且金额在所选范围的,yes
			for(Revenue r:list2) 
				if(Integer.parseInt(r.getIncome_num())<=monend&&Integer.parseInt(r.getIncome_num())>=monstart) 
					getlist(r);
			toArr();
			break;
		case "010":
			//查询所有，且日期在所选范围,yes
			
			for(Revenue r:list2) {
				
					if(getdate(r)<=dateend&& getdate(r)>=datestart) {
						getlist(r);
				}
			}
			toArr();
			break;
		case "011":
			//查询所有，且日期和金额在所选范围,yes
			for(Revenue r:list2) {
				
				if(getdate(r)<=dateend&& getdate(r)>=datestart&&Integer.parseInt(r.getIncome_num())<=monend&&Integer.parseInt(r.getIncome_num())>=monstart) {
					getlist(r);
				}
			}
			toArr();
			break;
		case "100":
			//查询给定来源的所有,yes
			for(Revenue r:list2) {
				if(r.getIncome_source().equals(source)) {
					getlist(r);
				}
			}
			toArr();
			break;
		case "101":
			//查询给定来源的所有，且金额在所选范围,yes
			for(Revenue r:list2) {
				if(r.getIncome_source().equals(source)&&(Integer.parseInt(r.getIncome_num())<=monend&&Integer.parseInt(r.getIncome_num())>=monstart)) {
					getlist(r);
				}
			}
			toArr();
			break;
		case "110":
//			//查询给定来源的所有，且日期在所选范围,yes
			for(Revenue r:list2) {
				if(r.getIncome_source().equals(source)&&getdate(r)<=dateend&& getdate(r)>=datestart) {
					
					getlist(r);
				}
			}
			toArr();
			break;
		case "111":
			//查询给定来源的所有，且日期和金额在所选范围
			for(Revenue r:list2) {
				if(r.getIncome_source().equals(source)&&(getdate(r)<=dateend&& getdate(r)>=datestart)&&(Integer.parseInt(r.getIncome_num())<=monend&&Integer.parseInt(r.getIncome_num())>=monstart)) {
					
					getlist(r);
				}
			}
			toArr();
			break;
		}

		//获取map
		List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < date.length; i++) {
			Map<String, Object> listem = new HashMap<String, Object>();
			listem.put("date", date[i]);
			listem.put("category",category[i]);
			listem.put("money", money[i]);
			listems.add(listem);
		}
		
		SimpleAdapter simplead = new SimpleAdapter(this, listems,
				R.layout.item, new String[] { "date","category","money"},
				new int[] {R.id.it_date,R.id.it_category,R.id.it_money});
		
		((ListView)findViewById(R.id.list)).setAdapter(simplead);
	}
	public void getlist(Revenue r) {
		dates.add(r.getDate());
		categories.add(r.getIncome_source());
		it_money.add(r.getIncome_num());
	}
	public int getdate(Revenue r) {
		String[] re=r.getDate().toString().split("-");
		return Integer.parseInt(re[0])*365+Integer.parseInt(re[1])*30+Integer.parseInt(re[2])*1;
	}
	public void toArr() {
		date=dates.toArray(new String[0]);
		category=categories.toArray(new String[0]);
		money=it_money.toArray(new String[0]);
	}
}
