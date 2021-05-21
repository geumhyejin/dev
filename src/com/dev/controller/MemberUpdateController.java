package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력정보를 받아와서 수정처리후 memberUpdateOutput으로 보냄
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String mail = request.getParameter("mail");

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPasswd(passwd);
		member.setMail(mail);

		MemberService service =MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberUpdateOutput.jsp"); 
		rd.forward(request, response);
		
	
	}

}
