<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String value = "안녕하세용";
	// sendRedirect할 경우 한글이 포함되어 있는 경우에는 인코딩해서 전달해야 한다.
	// 인코딩하지 않을 경우 즉, jsp09_parameters.jsp?hello=안녕하세용 형태로 전달이 된다면 에러가 발생한다.
	value = URLEncoder.encode(value, "utf-8");
	//value = URLDecoder.decode(value, "utf-8");
	response.sendRedirect("jsp09_parameters.jsp?hello=" + value);
%>