package com.hibernateImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernateInter.queryMethod;

import cn.utils.hibernateUtils;

public class query<E> implements queryMethod{
	public  String dynamicQuery(Class classarg,Object  ...obj){
		Session session=hibernateUtils.getSession();
		//start
		String classname=classarg.getSimpleName();
		String sqlcoreblock="",result="";
		for (int i = 0; i < obj.length; i++) {
			sqlcoreblock+=(classname+"."+obj[i]);
			if(obj[i]==obj[obj.length-1]) {
			}else {
				sqlcoreblock+=",";
			}
		}
		String hql="select new "+classname+"("+sqlcoreblock+") from "+classname+" as "+classname;
		Query query=session.createQuery(hql);
		List list = query.list();
		Iterator iterator =  list.iterator();
		while(iterator.hasNext()) {
			String[]  relist=iterator.next().toString().split(",");
			for(String s:relist) {
				if(s.indexOf("null")!=-1) {
					continue;
				}
				result+=s+",";
			}
			result=result.substring(0, result.length()-2)+"\n";
		}
		session.close();
		return result;
	}
	

//	public static void main(String[] args) {
//		query r=new query();
//		Customer customer=new Customer();
//		//System.out.println(customer.);
//		boolean a=r.paramQuery(Customer.class, "asd", "223", "name", "password");
//		System.out.println(a==true);
//	}


	@Override
	public boolean paramQuery(Class classarg, Object name, Object password, Object idtag, Object passwordtag) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Session session = hibernateUtils.getSession();
		String sql="",classname="";
		classname=classarg.getSimpleName();
		idtag=idtag.toString();
		passwordtag=passwordtag.toString();
		sql="from "+classname+" where "+idtag+" like ? and "+passwordtag+" like ?";
		Query query = session.createQuery(sql);
		query.setString(0, (String)name);
		query.setString(1, (String)password);
		flag=!query.list().isEmpty();
		System.out.println("-----------------------");
		System.out.println(flag);
		session.close();
		return flag;
	}
}



















