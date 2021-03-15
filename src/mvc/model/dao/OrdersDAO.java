package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

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
	 * 
	 * */
	List<Orders> printOrderList()throws SQLException;
	/** 훈석
	 * 자판기별 매출 보기
	 * SELECT VM_NO 자판기번호, SUM(TOTAL_PRICE) 총판매액, SUM(QTY) 총판매개수 FROM ORDERS GROUP BY VM_NO;
	 * */
	List<Orders> printVmSalesSelect() throws SQLException;
	
	/** 수현
	 * 일별 매출 보기
	 * select sale_date, sum(total_price)일매출, sum(qty)총판매개수 from orders group by sale_date;
	 * */
	List<Orders> printDaySalesSelect() throws SQLException;
	
	/** 정남
	 * 상품별 매출 보기
	 * select m.menu_name 메뉴이름, o.total 판매액, o.qty 판매개수 
	 *	from (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o
	 *	join menu m
	 *	using(menu_code);
	 * */
	List<Orders> printMenuSalesSelect() throws SQLException;
}
