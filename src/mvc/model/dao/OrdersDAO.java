package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/** ������
	   * ���Ǳ� ��ǰ �����ϱ�
	   *  1) orders���̺� insert
	   *  2) ���(stock)���� ��Ű��(update)
	   * */
	int ordersInsert(int menuCode, String vmNo, int qty)throws SQLException;
	/**
	 * �����ڰ� �ֹ����� ����
	 * file�����ؼ� ó���� ����
	 * */
	
	/** ���� �����ϱ�
	 * ���Ǳ⺰ ���� ����
	 * */
	
	/** ���� �����ϱ�
	 * �Ϻ� ���� ����
	 * select sale_date, sum(total_price)�ϸ���, sum(qty)���ǸŰ��� from orders group by sale_date;

	 * */
	
	/** ���� �����ϱ�
	 * ��ǰ�� ���� ����
	 * select m.menu_name �޴��̸�, o.total �Ǹž�, o.qty �ǸŰ��� 
	 *	from (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o
	 *	join menu m
	 *	using(menu_code);
	 * */
}
