package com.hibernateInter;

public interface queryMethod {
	/**
	 * dynamicQuery
	 * how to query:Depends on the number of parameters
	 * 
	 * paramQuery
	 * Match whether there is a result or not. Use parameter placeholder
	 * 
	 * 
	 * 
	 * */
	public String dynamicQuery(Class classarg,Object  ...obj);
	public boolean paramQuery(Class classarg,Object name,Object password,Object idtag,Object passwordtag);
}
