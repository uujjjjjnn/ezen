<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	url관련태그는 url생성기능과 redirect처리기능을 제공한다.
 -->
 <!-- https://search.daum.net/search?w=news&q=%EB%A7%88%EB%A3%A8%EB%8A%94%EA%B0%95%EC%A5%90 -->
 <c:url var="search" value="https://search.daum.net/search">
 	<c:param name="w" value="news"></c:param>
 	<c:param name="q" value="마루는강쥐" />
 </c:url>
 
 <ul>
 	<li><a href="${ search }">다음뉴스에서 마루는강쥐 검색하기</a></li>
 	<li><c:url value="jsp02_if.jsp"/></li>
 	<li><c:url value="./jsp02_if.jsp"/></li>
 </ul>
 
 <c:redirect url="http://www.google.com"/>  <!-- 구글페이지로 넘어감 -->