package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/**
	   * ���Ǳ� ��ǰ �����ϱ�
	   *  1) orders���̺� insert
	   *  2) order_line���̺� insert
	   *  3) ���(stock)���� ��Ű��(update)
	   * */
	int orderInsert(Orders order)throws SQLException;
	/**
	 * �����ڰ� �ֹ����� ����
	 * file�����ؼ� ó���� ����
	 * */
	
	/**
	 * ���Ǳ⺰ ���� ����
	 * */
	
	/**
	 * �Ϻ� ���� ����
	 * */
	
	/**
	 * ��ǰ�� ���� ����
	 * */
}
