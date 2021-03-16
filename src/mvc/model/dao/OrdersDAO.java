package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/** 
	 * 자판기 상품 구매하기
	 * */
	int ordersInsert(int menuCode, String vmNo, int qty)throws SQLException;
	
	
	/**
	 * 관리자가 주문내역 보기
	 * */
	List<Orders> printOrderList()throws SQLException;
	
	
	/** 
	 * 자판기별 매출 보기
	 * */
	List<Orders> printVmSalesSelect() throws SQLException;
	
	
	/**
	 * 일별 매출 보기
	 * */
	List<Orders> printDaySalesSelect() throws SQLException;
	
	/** 
	 * 상품별 매출 보기
	 * */
	List<Orders> printMenuSalesSelect() throws SQLException;
	
	/**
	 * 월별 매출 보기
	 * */
	List<Orders> printMonthSalesSelect() throws SQLException;
}
