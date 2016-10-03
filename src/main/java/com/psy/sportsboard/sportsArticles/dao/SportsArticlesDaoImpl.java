package com.psy.sportsboard.sportsArticles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.psy.sportsboard.sportsArticles.vo.SportsArticlesVO;
import com.psy.sportsboard.support.DaoSupport;
import com.psy.sportsboard.support.Query;
import com.psy.sportsboard.support.QueryAndResult;
import com.psy.sportsboard.user.vo.UserVO;

public class SportsArticlesDaoImpl extends DaoSupport implements SportsArticlesDao {

	@Override
	public List<SportsArticlesVO> getArticlesOf() {
		
		return selectList(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	S.SPRT_ATCL_ID, ");
				query.append(" S.SPRT_ATCL_SBJ, S.SPRT_ATCL_CNNT, TO_CHAR(S.CRT_DT, 'YYYY-MM-DD') CRT_DT, ");
				query.append(" S.HIT_CNT, S.RCMD_CNT, S.USR_ID, S.FILE_NM, U.USR_NM, U.POINT ");
				query.append(" FROM		SPRT_ATCL S, USR U");
				query.append(" WHERE	U.USR_ID = S.USR_ID ");
				query.append(" ORDER	BY SPRT_ATCL_ID DESC ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {

				List<SportsArticlesVO> articles = new ArrayList<SportsArticlesVO>();
				SportsArticlesVO articlesVO = null;
				UserVO userVO = null;
				
				while(rs.next()){
					articlesVO = new SportsArticlesVO();
					articlesVO.setSportsArticleId(rs.getString("SPRT_ATCL_ID"));
					articlesVO.setSportsArticleSubject(rs.getString("SPRT_ATCL_SBJ"));
					articlesVO.setSportsArticleContent(rs.getString("SPRT_ATCL_CNNT"));
					articlesVO.setCreateDate(rs.getString("CRT_DT"));
					articlesVO.setHitCount(rs.getInt("HIT_CNT"));
					articlesVO.setRecommedCount(rs.getInt("RCMD_CNT"));
					articlesVO.setUserId(rs.getString("USR_ID"));
					articlesVO.setFileName(rs.getString("FILE_NM"));
					userVO = articlesVO.getUserVO();
					userVO.setNickName(rs.getString("USR_NM"));
					userVO.setPoint(rs.getInt("POINT"));
					
					articles.add(articlesVO);
				}
				return articles;
			}
		});
	}
	@Override
	public int addArticle(SportsArticlesVO articlesVO) {
		
		return insert(new Query() {
			
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO SPRT_ATCL ( ");
				query.append(" SPRT_ATCL_ID, SPRT_ATCL_SBJ, SPRT_ATCL_CNNT,  ");
				query.append(" CRT_DT, HIT_CNT, RCMD_CNT, USR_ID, FILE_NM ) ");
				query.append(" VALUES ( ");
				query.append(" 'AR-'|| TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SPRT_ATCL_ID_SEQ.NEXTVAL,6,0), ");
				query.append(" ?, ?, SYSDATE, 0, 0, ?, ? ) ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesVO.getSportsArticleSubject());
				pstmt.setString(2, articlesVO.getSportsArticleContent());
				pstmt.setString(3, articlesVO.getUserId());
				pstmt.setString(4, articlesVO.getFileName());
				
				return pstmt;
			}
		});
	}
	@Override
	public SportsArticlesVO getArticleBy(String articleId) {

		return (SportsArticlesVO) selectOne(new QueryAndResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	S.SPRT_ATCL_ID, ");
				query.append(" S.SPRT_ATCL_SBJ, S.SPRT_ATCL_CNNT, TO_CHAR(S.CRT_DT, 'YYYY-MM-DD') CRT_DT, ");
				query.append(" S.HIT_CNT, S.RCMD_CNT, S.USR_ID, S.FILE_NM, U.USR_NM, U.POINT ");
				query.append(" FROM		SPRT_ATCL S, USR U");
				query.append(" WHERE	U.USR_ID = S.USR_ID ");
				query.append(" AND		S.SPRT_ATCL_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
			
				SportsArticlesVO articlesVO = null;
				UserVO userVO = null;
				
				while(rs.next()){
					articlesVO = new SportsArticlesVO();
					articlesVO.setSportsArticleId(rs.getString("SPRT_ATCL_ID"));
					articlesVO.setSportsArticleSubject(rs.getString("SPRT_ATCL_SBJ"));
					articlesVO.setSportsArticleContent(rs.getString("SPRT_ATCL_CNNT"));
					articlesVO.setCreateDate(rs.getString("CRT_DT"));
					articlesVO.setHitCount(rs.getInt("HIT_CNT"));
					articlesVO.setRecommedCount(rs.getInt("RCMD_CNT"));
					articlesVO.setUserId(rs.getString("USR_ID"));
					articlesVO.setFileName(rs.getString("FILE_NM"));
					userVO = articlesVO.getUserVO();
					userVO.setNickName(rs.getString("USR_NM"));
					userVO.setPoint(rs.getInt("POINT"));
					
				}
				return articlesVO;
			}
		});
	}
	@Override
	public int delete(String articleId) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM		SPRT_ATCL ");
				query.append(" WHERE	SPRT_ATCL_ID = ? ");

				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);
				return pstmt;
			}
		});
	}
	
	@Override
	public int updateHitCount(String articleId) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE SPRT_ATCL ");
				query.append(" SET HIT_CNT = HIT_CNT + 1 ");
				query.append(" WHERE SPRT_ATCL_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);
				
				return pstmt;
			}
		});
	}
	
	@Override
	public int updateRecommend(String articleId) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE SPRT_ATCL ");
				query.append(" SET RCMD_CNT = RCMD_CNT + 1, ");
				query.append(" 		HIT_CNT = HIT_CNT - 1 ");
				query.append(" WHERE SPRT_ATCL_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articleId);
				
				return pstmt;
				
			}
		});
	}
	
	
	
	@Override
	public int modifyArticle(SportsArticlesVO articlesVO) {
		
		return insert(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE SPRT_ATCL ");
				query.append(" SET	SPRT_ATCL_SBJ = ?, ");
				query.append(" 		SPRT_ATCL_CNNT = ?, ");
				query.append(" 		HIT_CNT = HIT_CNT - 2 ");
				query.append(" WHERE SPRT_ATCL_ID = ? ");
				
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesVO.getSportsArticleSubject() );
				pstmt.setString(2, articlesVO.getSportsArticleContent() );
				pstmt.setString(3, articlesVO.getSportsArticleId() );
				
				return pstmt;
			}
		});
	}
	
}
