package com.psy.sportsboard.sportsArticles.vo;

import com.psy.sportsboard.user.vo.UserVO;

public class SportsArticlesVO {
	private	 String sportsArticleId;
	private	 String sportsArticleSubject;
	private	 String sportsArticleContent;
	private	 String createDate;
	private	 int hitCount;
	private int recommedCount;
	private String userId;
	private String fileName;
	private UserVO userVO;
	
	public SportsArticlesVO() {
		userVO = new UserVO();
	}
	
	public String getSportsArticleId() {
		return sportsArticleId;
	}
	public void setSportsArticleId(String sportsArticleId) {
		this.sportsArticleId = sportsArticleId;
	}
	public String getSportsArticleSubject() {
		return sportsArticleSubject;
	}
	public void setSportsArticleSubject(String sportsArticleSubject) {
		this.sportsArticleSubject = sportsArticleSubject;
	}
	public String getSportsArticleContent() {
		return sportsArticleContent;
	}
	public void setSportsArticleContent(String sportsArticleContent) {
		this.sportsArticleContent = sportsArticleContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getRecommedCount() {
		return recommedCount;
	}
	public void setRecommedCount(int recommedCount) {
		this.recommedCount = recommedCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	
}
