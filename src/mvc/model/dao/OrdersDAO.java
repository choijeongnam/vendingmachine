package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/** 
	 * ���Ǳ� ��ǰ �����ϱ�
	 * */
	int ordersInsert(int menuCode, String vmNo, int qty)throws SQLException;
	
	
	/**
	 * �����ڰ� �ֹ����� ����
	 * */
	List<Orders> printOrderList()throws SQLException;
	
	
	/** 
	 * ���Ǳ⺰ ���� ����
	 * */
	List<Orders> printVmSalesSelect() throws SQLException;
	
	
	/**
	 * �Ϻ� ���� ����
	 * */
	List<Orders> printDaySalesSelect() throws SQLException;
	
	/** 
	 * ��ǰ�� ���� ����
	 * */
	List<Orders> printMenuSalesSelect() throws SQLException;
	
	/**
	 * ���� ���� ����
	 * */
	List<Orders> printMonthSalesSelect() throws SQLException;
}
