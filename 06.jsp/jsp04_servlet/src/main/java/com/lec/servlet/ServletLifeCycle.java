package com.lec.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeCycle
 */
@WebServlet(
		urlPatterns = { "/life", "/cycle"}, 
		initParams = { @WebInitParam(name = "user", value = "root"), 
					   @WebInitParam(name = "pass", value = "12345", description = "비밀번호")})
public class ServletLifeCycle extends HttpServlet {
	
	// 생성자
	public ServletLifeCycle() { 
		System.out.println("1. 서블릿생성");
	}

	@PostConstruct
	private void initPostConstruct() {
		System.out.println("2. 객체생성 후 실행");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("3. 서블릿 초기화 메서드 init() 실행");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("4. doGet/doPost메서드 실행");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("5. 객체가 소멸전에 preDestroy() 메서드 실행");
	}
	 
	@Override
	public void destroy() {
		System.out.println("6. 객체가 소멸전될 때 destroy() 메서드 실행");
	}
	
	
	
	
	
}
