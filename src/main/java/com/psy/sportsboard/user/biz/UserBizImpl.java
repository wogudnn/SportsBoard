package com.psy.sportsboard.user.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.psy.sportsboard.constants.Session;
import com.psy.sportsboard.user.dao.UserDao;
import com.psy.sportsboard.user.dao.UserDaoImpl;
import com.psy.sportsboard.user.vo.UserVO;

public class UserBizImpl implements UserBiz {
	
	private UserDao userDao;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}
	@Override
	public boolean isExsistEmail(String email) {
		return userDao.isExsistEmail(email) > 0;
	}
	@Override
	public boolean addUser(UserVO userVO) {
		
		return userDao.addUser(userVO)>0;
	}
	@Override
	public boolean signIn(UserVO userVO, HttpServletRequest request) {
		
		UserVO user = userDao.signIn(userVO);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute(Session.USER_INFO, user);
			return true;
		}
		
		return false;
	}
}
