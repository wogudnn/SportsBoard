package com.psy.sportsboard.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.sportsboard.support.Param;
import com.psy.sportsboard.user.biz.UserBiz;
import com.psy.sportsboard.user.biz.UserBizImpl;
import com.psy.sportsboard.user.vo.UserVO;

public class DoSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DoSignUpServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = Param.getStringParam(request, "email");
		String nickname = Param.getStringParam(request, "nickname");
		String password = Param.getStringParam(request, "password1");
		String password2 = Param.getStringParam(request, "password2");
		
		if(email.length()==0){
			response.sendRedirect("/SportsBoard/signUp?errorCode=2");
			return;
		}
		if(nickname.length()==0){
			response.sendRedirect("/SportsBoard/signUp?errorCode=2");
			return;
		}
		if(password.length()==0){
			response.sendRedirect("/SportsBoard/signUp?errorCode=2");
			return;
		}
		if(password2.length()==0){
			response.sendRedirect("/SportsBoard/signUp?errorCode=2");
			return;
		}
		
		
		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		userVO.setNickName(nickname);
		userVO.setPassword(password);
		
		boolean isSuccess = userBiz.addUser(userVO);
		if(isSuccess) {
			response.sendRedirect("/SportsBoard/signIn");
		}
		else{
			response.sendRedirect("/SportsBoard/signUp?errorCode=1");
		}
	
	}

}
