package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Orders;


public interface OrdersDAO {
	/** 최정남
	   * 자판기 상품 구매하기
	   *  1) orders테이블에 insert
	   *  2) 재고량(stock)감소 시키기(update)
	   * */
	int ordersInsert(int menuCode, String vmNo, int qty)throws SQLException;
	/**
	 * 관리자가 주문내역 보기
	 * file생성해서 처리할 예정
	 * */
	
	/** 각자 공부하기
	 * 자판기별 매출 보기
	 * */
	
	/** 각자 공부하기
	 * 일별 매출 보기
	 * select sale_date, sum(total_price)일매출, sum(qty)총판매개수 from orders group by sale_date;

	 * */
	
	/** 각자 공부하기
	 * 상품별 매출 보기
	 * select m.menu_name 메뉴이름, o.total 판매액, o.qty 판매개수 
	 *	from (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o
	 *	join menu m
	 *	using(menu_code);
	 * */
}
