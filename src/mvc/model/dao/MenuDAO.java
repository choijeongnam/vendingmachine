package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.dto.Orders;
import mvc.util.DBUtil;


public interface MenuDAO {
	
	/** 
	 * 상품별 매출 보기
	 * */
	List<Menu> printMenuSalesSelect() throws SQLException;
	
	
	/**
	 * 관리자가 메뉴 확인하기
	 * */
	List<Menu> menuSelect() throws SQLException;
	
	/**
	 * 지점 별 메뉴 보여주기
	 * */
	List<Menu> goodsSelect(String vmNo) throws SQLException;
		
}
