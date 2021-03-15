package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

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
	 * 
	 * */
	List<Orders> printOrderList()throws SQLException;
	/** �Ƽ�
	 * ���Ǳ⺰ ���� ����
	 * SELECT VM_NO ���Ǳ��ȣ, SUM(TOTAL_PRICE) ���Ǹž�, SUM(QTY) ���ǸŰ��� FROM ORDERS GROUP BY VM_NO;
	 * */
	List<Orders> printVmSalesSelect() throws SQLException;
	
	/** ����
	 * �Ϻ� ���� ����
	 * select sale_date, sum(total_price)�ϸ���, sum(qty)���ǸŰ��� from orders group by sale_date;
	 * */
	List<Orders> printDaySalesSelect() throws SQLException;
	
	/** ����
	 * ��ǰ�� ���� ����
	 * select m.menu_name �޴��̸�, o.total �Ǹž�, o.qty �ǸŰ��� 
	 *	from (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o
	 *	join menu m
	 *	using(menu_code);
	 * */
	List<Orders> printMenuSalesSelect() throws SQLException;
}
