package com.psy.sportsboard.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;
import com.psy.sportsboard.support.DaoSupport;
import com.psy.sportsboard.support.Query;
import com.psy.sportsboard.support.QueryAndResult;
import com.psy.sportsboard.user.vo.UserVO;

public class UserDaoImpl extends DaoSupport implements UserDao {

	@Override
	public int isExsistEmail(final String email) {
		
		return (int) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	COUNT(1) CNT");
				query.append(" FROM		USR ");
				query.append(" WHERE	USR_EMAIL= ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, email);
				
				return 	pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				if(rs.next()){
					return rs.getInt("CNT");
				}
				
				return 0;
			}
		});
	}
	
	@Override
	public int addUser(UserVO userVO) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				
				query.append(" INSERT INTO USR ( ");
				query.append(" USR_ID, USR_EMAIL, USR_PWD, ");
				query.append(" USR_NM, CRT_DT, POINT ) ");
				query.append(" VALUES ( ");
				query.append(" 'UR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(USR_ID_SEQ.NEXTVAL,6,0), ");
				query.append(" ?, ?, ?, SYSDATE, 0 ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());
				pstmt.setString(2, userVO.getPassword());
				pstmt.setString(3, userVO.getNickName());
				
				return pstmt;
			}
		});
	}
	@Override
	public UserVO signIn(UserVO userVO) {
		
		return (UserVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	USR_ID, ");
				query.append(" 			USR_EMAIL, USR_PWD, ");
				query.append(" 			USR_NM,  ");
				query.append(" 			TO_CHAR(CRT_DT, 'YYYY-MM-DD') CRT_DT ,  ");
				query.append(" 			POINT ");
				query.append(" FROM		USR ");
				query.append(" WHERE	USR_EMAIL = ? ");
				query.append(" AND		USR_PWD = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getEmail());
				pstmt.setString(2, userVO.getPassword());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				
				UserVO userVO = null;
				if(rs.next()){
					userVO = new UserVO();
					userVO.setUserId(rs.getString("USR_ID"));
					userVO.setEmail(rs.getString("USR_EMAIL"));
					userVO.setPassword(rs.getString("USR_PWD"));
					userVO.setNickName(rs.getString("USR_NM"));
					userVO.setCreateDate(rs.getString("CRT_DT"));
					userVO.setPoint(rs.getInt("POINT"));
					
				}
				
				return userVO;
			}
		});
	}
	
	@Override
	public int updatePoint(SportsArticlesVO articlesVO) {

		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	USR  ");
				query.append(" SET		POINT = POINT + 10  ");
				query.append(" WHERE	USR_ID = ?  ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesVO.getUserId());
				
				return pstmt;
			}
		});
	}

	
}
