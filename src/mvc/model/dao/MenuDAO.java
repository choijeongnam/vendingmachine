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
	 * ��ǰ�� ���� ����
	 * */
	List<Menu> printMenuSalesSelect() throws SQLException;
	
	
	/**
	 * �����ڰ� �޴� Ȯ���ϱ�
	 * */
	List<Menu> menuSelect() throws SQLException;
	
	/**
	 * ���� �� �޴� �����ֱ�
	 * */
	List<Menu> goodsSelect(String vmNo) throws SQLException;
		
}
