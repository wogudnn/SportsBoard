package com.psy.sportsboard.sportsArticles.dao;

import java.util.List;

import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;

public interface SportsArticlesDao {

	public List<SportsArticlesVO> getArticlesOf();

	public int addArticle(SportsArticlesVO articlesVO);

	public SportsArticlesVO getArticleBy(String articleId);

	public int delete(String articleId);
	
	public int updateHitCount(String articleId);

	public int updateRecommend(String articleId);

	public int modifyArticle(SportsArticlesVO articlesVO);

}
