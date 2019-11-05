package com.loginservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernateImpl.query;

import cn.itcast.domain.Customer;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);//dopost这里写的就是
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String loginid = request.getParameter("loginid");
		String pwd = request.getParameter("pwd");
		String autologin = request.getParameter("autologin");
		query q = new query();
		System.out.println(q.paramQuery(Customer.class, loginid, pwd, "name","password"));
		if(q.paramQuery(Customer.class, loginid, pwd, "name","password")==true) {
			if(autologin!=null&&autologin.equals("yes")) {
					Cookie cookie=new Cookie("loginid", loginid);
					Cookie cookie2 = new Cookie("password", pwd);
					//cookie.setMaxAge(10);
					//cookie2.setMaxAge(10);
					response.addCookie(cookie2);
					response.addCookie(cookie);
			}
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("密码错误");
			response.sendRedirect("login.jsp");
		}
	}
}
