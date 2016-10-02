package com.psy.sportsboard.user.dao;

import com.psy.sportsboard.user.vo.UserVO;

public interface UserDao {

	public int isExsistEmail(String email);

	public int addUser(UserVO userVO);

	public UserVO signIn(UserVO userVO);

}
