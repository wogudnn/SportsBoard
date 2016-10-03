package com.psy.sportsboard.sportsArticles.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBiz;
import com.psy.sportsboard.sportsArticles.biz.SportsArticlesBizImpl;
import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;
import com.psy.sportsboard.support.Param;

public class ViewDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SportsArticlesBiz articlesBiz;
	public ViewDetailPageServlet() {
		super();
		articlesBiz = new SportsArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPath = "/WEB-INF/view/sportsArticles/detail.jsp";
		String articleId = Param.getStringParam(request, "articleId");
		
		if(articleId.length()==0){
			response.sendRedirect("/SportsBoard/board/list?errorCode=1");
		}
		
		SportsArticlesVO articlesVO = articlesBiz.getArticleBy(articleId);
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("articlesVO", articlesVO);
		rd.forward(request, response);
		
	}

}
