package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 전체 애플리케이션의 컨트롤러 등록 - 관리.
 * *.do, *.action  
 * 
 */

public class FrontController extends HttpServlet{
	
	 HashMap<String, Controller> list;
	 String charset = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		
		// front 요청하면 제일 처음 한번만 실행됨
		list = new HashMap<>();
		System.out.println("front init()");
		//list.put("/요청페이지.do"호출 , "컨트롤러를통해서 페이지요청");
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();   //		/dev/insertMember.do
		String contextPath = req.getContextPath();	//   /dev
		//insertMember.do
		String path = uri.substring(contextPath.length());	
		System.out.println(path);
		
		Controller sub = list.get(path);   //Controller  sub.execute(req, resp); 실행시키고싶음
		sub.execute(req, resp);
	}
}
