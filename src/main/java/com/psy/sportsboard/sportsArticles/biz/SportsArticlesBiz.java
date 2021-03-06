package com.psy.sportsboard.sportsArticles.biz;

import java.util.List;

import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;

public interface SportsArticlesBiz {

	public List<SportsArticlesVO> getArticlesOf();

	public boolean addArticle(SportsArticlesVO articlesVO);

	public SportsArticlesVO getArticleBy(String articleId);

	public boolean delete(String articleId);

	public boolean updateRecommend(String articleId);

	public boolean modifyArticle(SportsArticlesVO articlesVO);

}
