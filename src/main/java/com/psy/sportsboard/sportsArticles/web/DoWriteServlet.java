package com.psy.sportsboard.sportsArticles.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psy.sportsboard.constants.Session;
import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBiz;
import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBizImpl;
import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;
import com.psy.sportsboard.support.Param;
import com.psy.sportsboard.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SportsArticlesBiz articlesBiz;
	public DoWriteServlet() {
		super();
		articlesBiz = new SportsArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subJect = Param.getStringParam(request, "subJect");
		String content = Param.getStringParam(request, "content");
		
		if(subJect.length()==0){
			response.sendRedirect("/SportsBoard/board/write?errorCode=2");
			return;
		}
		if(content.length()==0){
			response.sendRedirect("/SportsBoard/board/write?errorCode=2");
			return;
		}
		SportsArticlesVO articlesVO = new SportsArticlesVO();
		articlesVO.setSportsArticleSubject(subJect);
		articlesVO.setSportsArticleContent(content);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		articlesVO.setUserId(userVO.getUserId());
		boolean isSuccess = articlesBiz.addArticle(articlesVO);
		if(isSuccess){
			response.sendRedirect("/SportsBoard/board/list");
		}
		else{
			response.sendRedirect("/SportsBoard/board/write?errorCode=1");
		}
		
	}

}
