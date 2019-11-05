package com.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//从请求中拿cookie，有就直接登录
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		Cookie[] cookies=httpServletRequest.getCookies();
		String loginid = null;
		String pwd = null;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("loginid")) {loginid=c.getValue();
				
				System.out.println(loginid);}
				if(c.getName().equals("password")) {
					pwd=c.getValue();
					System.out.println(pwd);
				} 
			}
			
			if(loginid!=null&&pwd!=null) {	
				httpServletResponse.sendRedirect("login?loginid="+loginid+"&pwd="+pwd);
			}else {
				System.out.println("hhhhhhhhhhhhhhhh");
				arg2.doFilter(httpServletRequest, httpServletResponse);
			}
		}
		else {
			System.out.println("aaaaaaaaaaa");
			arg2.doFilter(httpServletRequest, httpServletResponse);
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
