package com.psy.sportsboard.sportsArticles.biz;

import java.util.List;

import com.psy.sportsboard.sportsArticles.dao.SportsArticlesDao;
import com.psy.sportsboard.sportsArticles.dao.SportsArticlesDaoImpl;
import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;

public class SportsArticlesBizImpl implements SportsArticlesBiz {

	private SportsArticlesDao articlesDao;
	
	public SportsArticlesBizImpl() {
		articlesDao = new SportsArticlesDaoImpl();
	}
	@Override
	public List<SportsArticlesVO> getArticlesOf() {

		return articlesDao.getArticlesOf();
	}
	@Override
	public boolean addArticle(SportsArticlesVO articlesVO) {
		
		return articlesDao.addArticle(articlesVO) > 0;
	}
	@Override
	public SportsArticlesVO getArticleBy(String articleId) {

		return articlesDao.getArticleBy(articleId);
	}
	@Override
	public boolean delete(String articleId) {
		
		return articlesDao.delete(articleId)>0;
	}
}
