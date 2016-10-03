package com.psy.sportsboard.sportsArticles.biz;

import java.util.List;

import com.psy.sportsboard.sportsArticles.dao.SportsArticlesDao;
import com.psy.sportsboard.sportsArticles.dao.SportsArticlesDaoImpl;
import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;
import com.psy.sportsboard.user.dao.UserDao;
import com.psy.sportsboard.user.dao.UserDaoImpl;

public class SportsArticlesBizImpl implements SportsArticlesBiz {

	private SportsArticlesDao articlesDao;
	private UserDao userDao;
	public SportsArticlesBizImpl() {
		articlesDao = new SportsArticlesDaoImpl();
		userDao = new UserDaoImpl();
	}
	@Override
	public List<SportsArticlesVO> getArticlesOf() {

		return articlesDao.getArticlesOf();
	}
	@Override
	public boolean addArticle(SportsArticlesVO articlesVO) {
		
		userDao.updatePoint(articlesVO);
		
		return articlesDao.addArticle(articlesVO) > 0;
	}
	@Override
	public SportsArticlesVO getArticleBy(String articleId) {

		articlesDao.updateHitCount(articleId);
		
		return articlesDao.getArticleBy(articleId);
	}
	@Override
	public boolean delete(String articleId) {
		
		return articlesDao.delete(articleId)>0;
	}
	@Override
	public boolean updateRecommend(String articleId) {
		
		return articlesDao.updateRecommend(articleId) > 0;
	}
}
