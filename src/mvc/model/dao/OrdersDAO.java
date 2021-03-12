package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/**
	   * 자판기 상품 구매하기
	   *  1) orders테이블에 insert
	   *  2) order_line테이블에 insert
	   *  3) 재고량(stock)감소 시키기(update)
	   * */
	int orderInsert(Orders order)throws SQLException;
	/**
	 * 관리자가 주문내역 보기
	 * file생성해서 처리할 예정
	 * */
	
	/**
	 * 자판기별 매출 보기
	 * */
	
	/**
	 * 일별 매출 보기
	 * */
	
	/**
	 * 상품별 매출 보기
	 * */
}
