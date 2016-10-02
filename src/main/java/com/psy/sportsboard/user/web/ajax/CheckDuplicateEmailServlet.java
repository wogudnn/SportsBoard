package com.psy.sportsboard.user.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.sportsboard.support.Param;
import com.psy.sportsboard.user.biz.UserBiz;
import com.psy.sportsboard.user.biz.UserBizImpl;

public class CheckDuplicateEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	public CheckDuplicateEmailServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = Param.getStringParam(request, "email");
		
		boolean isExsistEmail = userBiz.isExsistEmail(email);
		
		PrintWriter out = response.getWriter();
		out.write(isExsistEmail + "");
		out.flush();
		out.close();
	}

}
