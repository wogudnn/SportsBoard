package com.psy.sportsboard.user.biz;

import javax.servlet.http.HttpServletRequest;

import com.psy.sportsboard.user.vo.UserVO;

public interface UserBiz {

	public boolean isExsistEmail(String userEmail);

	public boolean addUser(UserVO userVO);

	public boolean signIn(UserVO userVO, HttpServletRequest request);

}
