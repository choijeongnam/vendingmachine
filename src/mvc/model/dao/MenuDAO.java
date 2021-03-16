package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.dto.Orders;


public interface MenuDAO {
	
	/** 
	 * ��ǰ�� ���� ����
	 * */
	List<Menu> printMenuSalesSelect() throws SQLException;
	
	
	/**
	 * �����ڰ� �޴� Ȯ���ϱ�
	 * */
	List<Menu> menuSelect() throws SQLException;
}
