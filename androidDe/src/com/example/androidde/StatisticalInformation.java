package com.example.androidde;

import java.util.ArrayList;

import com.example.database.ExpenditureDB;
import com.example.database.RevenueDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class StatisticalInformation extends Activity{
	private int checkis=0;
	ArrayList<Revenue> revenues;
	ArrayList<Expenditure> expenditures;
	private ArrayList<String> data_revenue,data_expenditure;
	String revenue,expenditure;
	RevenueDB revenueDB;
	ExpenditureDB expenditureDB;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistical_information);
		
		getdata();
		((RadioGroup)findViewById(R.id.category_type)).
		setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(group.getCheckedRadioButtonId()==1) {
					checkis=1;
				}
				if(group.getCheckedRadioButtonId()==2) {
					checkis=2;
				}
			}
		});
	}
	private void getdata() {
		// TODO Auto-generated method stub
		revenues=new RevenueDB(StatisticalInformation.this, "revenue").findAllRevenue();
		for(Revenue r:revenues) {
			revenue+="���ڣ�"+r.getDate()+", ����:"+r.getIncome_source()+",���"+r.getIncome_num()+"\n";
		}
		data_revenue=new ArrayList<>();
		data_expenditure=new ArrayList<>();
		data_revenue.add(revenue);
		expenditures=new ExpenditureDB(StatisticalInformation.this, "expenditure").findAllExpenditure();
		for(Expenditure e:expenditures) {
			expenditure+="���ڣ�"+e.getDate()+",֧����"+e.getOutcome_source()+",���"+e.getOutcome_num()+"\n";
		}
		data_expenditure.add(expenditure);
	}
	public void onClick1(View v) {
		if(checkis==0) {
			Toast.makeText(StatisticalInformation.this, "�㻹δѡ��һ�����", Toast.LENGTH_LONG).show();
		}
		if(checkis==1) {
			Toast.makeText(StatisticalInformation.this, "���������", Toast.LENGTH_LONG).show();
			((ListView)findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(StatisticalInformation.this,android.R.layout.simple_list_item_1,data_revenue));
		}
		if(checkis==2) {
			Toast.makeText(StatisticalInformation.this, "֧�������", Toast.LENGTH_LONG).show();
			((ListView)findViewById(R.id.list)).setAdapter(new ArrayAdapter<String>(StatisticalInformation.this,android.R.layout.simple_list_item_1,data_expenditure));
		}
	}
	public void onClick2(View v) {
		startActivity(new Intent(StatisticalInformation.this,MainActivity.class));
	}
}
