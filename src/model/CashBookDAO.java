package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class CashBookDAO {
	
	//가계부수정
	public int cashbookUpdate(CashBookVO book) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update cashbook set cashbook_date=?, cashbook_title=?, cashbook_cash=?, cashbook_category=? where cashbook_cashno=?";
		
		conn = DBUtil.getConnection();
		try {
			st=conn.prepareStatement(sql);
			st.setString(1, book.getCashbook_date());
			st.setString(2, book.getCashbook_title());
			st.setInt(3, book.getCashbook_cash());
			st.setString(4, book.getCashbook_category());
			st.setInt(5, book.getCashbook_cashno());
			result=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, st, conn);
			
		}
		return result;
	}
	
	
	//사용자수정
	public int memberUpdate(CashBookVO book, int memberId) {
	int result = 0;
	Connection conn = null;
	PreparedStatement st = null;
	String sql = "update cashmember set cashmember_pass=?, cashmember_mail=? where cashmember_id=?";
	
	conn = DBUtil.getConnection();
	try {
		st=conn.prepareStatement(sql);
		st.setString(1, book.getCashmember_pass());
		st.setString(2, book.getCashmember_mail());
		st.setInt(3, memberId);
		result=st.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.dbClose(null, st, conn);
		
	}
	return result;
}
	
	//가계부 기간별조회
	public List<CashBookVO> searchCondition(int memberId, String dateStart, String dateEnd) { 
		List<CashBookVO> listall = new ArrayList<CashBookVO>();
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from cashbook aa,cashcategory bb where(aa.cashbook_category = bb.cashcategory_no) and cashbook_memberid=? and (cashbook_date between ? and ?) order by cashbook_date asc";
		
		conn= DBUtil.getConnection();
		try {
			st=conn.prepareStatement(sql);
			st.setInt(1, memberId);
			st.setString(2, dateStart);
			st.setString(3, dateEnd);
			rs= st.executeQuery();
			while(rs.next()) {  
				CashBookVO book = new CashBookVO();
		    	book.setCashbook_cashno(rs.getInt("cashbook_cashno"));
				book.setCashbook_date(rs.getString("cashbook_date"));
				book.setCashbook_title(rs.getString("cashbook_title"));
				book.setCashbook_cash(rs.getInt("cashbook_cash"));		
				book.setCashbook_category(rs.getString("cashbook_category"));
				book.setCashbook_memberid(rs.getInt("cashbook_memberid"));
				book.setCashcategory_no( rs.getInt("cashcategory_no"));
				book.setCashcategory_type(rs.getString("cashcategory_type")); 
				book.setCashcategory_category(rs.getString("cashcategory_category"));
				
				listall.add(book);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return listall;
	}
	
	
	
	//가계부 기간별 수입 지출 합계
	public int report(int memberId, String dateStart, String dateEnd , CashBookVO book) { 
		
		int reportRs = 0;
		
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select sum(CASHBOOK_CASH) from cashbook aa,cashcategory bb where(aa.cashbook_category = bb.cashcategory_no) and cashbook_memberid=? and (cashbook_date between ? and ?) and cashcategory_type=?";
		
		conn= DBUtil.getConnection();
		try {
			st=conn.prepareStatement(sql);
			st.setInt(1, memberId);
			st.setString(2, dateStart);
			st.setString(3, dateEnd);
			st.setString(4, book.getCashcategory_type());
			rs= st.executeQuery();
			
			if(rs.next()) {
			reportRs = rs.getInt(1);
			}else {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return reportRs;
	}
	
	

	
	//사용자추가
	public int memberInsert(int insertid ,String insertpass, String insertmail) {
	int result = 0;
	Connection conn = null;
	PreparedStatement st = null;
	String sql = "insert into cashmember values(?, ?, ?)";
	
	conn = DBUtil.getConnection();
	try {
		st = conn.prepareStatement(sql);	
		st.setInt(1, insertid);
		st.setString(2, insertpass);
		st.setString(3, insertmail);

		
		result = st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.dbClose(null, st, conn);
	}
	return result;
	
	}
	
	
	//가계부삭제
	public int bookDelete(CashBookVO book) {
	int result = 0;
	Connection conn = null;
	PreparedStatement st = null;
	String sql = "delete from cashbook where cashbook_cashno=?";
	conn = DBUtil.getConnection();
	try {
		st=conn.prepareStatement(sql);
		st.setInt(1, book.getCashbook_cashno());
		result=st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.dbClose(null, st, conn);
	}
	return result;
	}
	
	
	//가계부입력
	public int bookInsert(CashBookVO book) {
	int result = 0;
	Connection conn = null;
	PreparedStatement st = null;
	//cashbook_no_seq.nextval,'2021/04/23', '식비', 3000, '식비', '200'
	String sql = "insert into cashbook values(cashbook_no_seq.nextval,?, ?, ?, ?, ?)";
	
	conn = DBUtil.getConnection();
	try {
		st = conn.prepareStatement(sql);
		st.setString(1, book.getCashbook_date());	
		st.setString(2, book.getCashbook_title());	
		st.setInt(3, book.getCashbook_cash());	
		//st.setString(4, book.getCashbook_type());	
		st.setString(4, book.getCashbook_category());	
		st.setInt(5, book.getCashbook_memberid());	
		
		result = st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.dbClose(null, st, conn);
	}
	return result;
	
	}
	
	//카테고리조회
	public List<CashBookCategoryVO> selectCategoryList() { 
		List<CashBookCategoryVO> categoryList = new ArrayList<CashBookCategoryVO>();
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from cashcategory order by cashcategory_no asc";
		
		conn= DBUtil.getConnection();
		try {
			st=conn.prepareStatement(sql);
			rs= st.executeQuery();
			while(rs.next()) {  
				CashBookCategoryVO book = new CashBookCategoryVO();
				
			book.setCashcategory_no(rs.getInt("cashcategory_no"));
			book.setCashcategory_type(rs.getString("cashcategory_type"));
			book.setCashcategory_category(rs.getString("cashcategory_category"));

				categoryList.add(book);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return categoryList;
	}
	
	
	
	//사용자별 모두조회 
	public List<CashBookVO> selectCashbookList(int memberId) { 
		List<CashBookVO> listall = new ArrayList<CashBookVO>();
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//String sql = "select * from cashbook where CASHBOOK_MEMBERID=? order by cashbook_date asc";
		String sql = "select * from cashbook aa,cashcategory bb where(aa.cashbook_category = bb.cashcategory_no) and cashbook_memberid=? order by cashbook_date asc";
		
		conn= DBUtil.getConnection();
		try {
			st=conn.prepareStatement(sql);
			st.setInt(1, memberId);
			rs= st.executeQuery();
			while(rs.next()) {  
				//CashBookVO cashbook = makeBook(rs);
				CashBookVO book = new CashBookVO();
		    	book.setCashbook_cashno(rs.getInt("cashbook_cashno"));
				book.setCashbook_date(rs.getString("cashbook_date"));
				book.setCashbook_title(rs.getString("cashbook_title"));
				book.setCashbook_cash(rs.getInt("cashbook_cash"));		
				book.setCashbook_category(rs.getString("cashbook_category"));
				book.setCashbook_memberid(rs.getInt("cashbook_memberid"));
				book.setCashcategory_no( rs.getInt("cashcategory_no"));
				book.setCashcategory_type(rs.getString("cashcategory_type")); 
				book.setCashcategory_category(rs.getString("cashcategory_category"));
				
				listall.add(book);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return listall;
	}
	
	
	
	//사용자삭제
	public int memberDelete(int memberId) {
	int result = 0;
	Connection conn = null;
	PreparedStatement st = null;
	String sql = "delete from cashmember where cashmember_id=?";
	conn = DBUtil.getConnection();
	try {
		st=conn.prepareStatement(sql);
		st.setInt(1, memberId);
		result=st.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtil.dbClose(null, st, conn);
	}
	return result;
	}
	
	
	//로그인
	public int bookLogin(int memberId, String memberPass) {
		int login=0;
		Connection conn= null;
		PreparedStatement st = null;
		ResultSet rs = null;
		conn= DBUtil.getConnection();
		String sql = "select cashmember_pass from cashmember where cashmember_id=?";
		
		try {
			st=conn.prepareStatement(sql);
			st.setInt(1, memberId);
			rs= st.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).contentEquals(memberPass)) {
					return 1; //성공
				}
				else {
					return 0;//불일치
				}
				
			}
			return -1; //id없음
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return -2;
		
	}
	
	
	
}
