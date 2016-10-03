package com.psy.sportsboard.sportsArticles.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBiz;
import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBizImpl;
import com.psy.sportsboard.support.Param;

public class DoRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SportsArticlesBiz articlesBiz;
	
	public DoRecommendServlet() {
		super();
		articlesBiz = new SportsArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleId = Param.getStringParam(request, "articleId");
		
		if(articleId.length()==0){
			response.sendRedirect("/SportsBoard/board/detail?errorCode=2&&articleId="+articleId);
			return;
		}
		
		boolean isSuccess = articlesBiz.updateRecommend(articleId);
		if(isSuccess) {
			response.sendRedirect("/SportsBoard/board/detail?articleId="+articleId);
		}
		else{
			response.sendRedirect("/SportsBoard/board/detail?errorCode=1&&articleId="+articleId);
		}
		
	}

}
