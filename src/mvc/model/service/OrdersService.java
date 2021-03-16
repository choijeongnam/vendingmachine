package mvc.model.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.OrdersDAO;
import mvc.model.dao.OrdersDAOImpl;
import mvc.model.dto.Orders;
import mvc.model.exception.NotFoundException;

public class OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	
	/**
	 * 관리자가 주문내역 보기
	 * */
	public void printOrderList() throws SQLException, IOException{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/view/주문내역서.txt"))){
			List<Orders> orderList = ordersDao.printOrderList();
			bw.write("\t\t\t==== 주문내역서 ====");
			bw.write("\r\n");
			bw.write("=================================================");
			bw.write("\r\n");
			bw.write("주문번호|메뉴코드|자판기번호|수량|총가격|판매날짜");
			bw.write("\r\n");
			
			for(Orders orders : orderList) {
				String print = orders.toString();
				bw.write("\t"+print);
				bw.write("\r\n"); 
			}
			bw.write("=================================================");
			bw.flush();
			bw.close();
		}catch(IOException e) {
			throw new IOException("주문내역서를 뽑지 못했습니다.");
		}
	}
	
	
	/**
	 * 자판기별 매출 조회
	 * */
	public List<Orders> printVmSalesSelect() throws SQLException, NotFoundException{
		List<Orders> list = ordersDao.printVmSalesSelect();
		if(list.size() == 0) throw new NotFoundException("현재 자판기 매출이 없습니다.");
		return list;
	}
	
	
	/**
	 * 일별 매출 조회
	 * */
	public List<Orders> printDaySalesSelect() throws SQLException{
		List<Orders> list = ordersDao.printDaySalesSelect();
		if(list.size() == 0) throw new SQLException("판매 내역이 없습니다.");
		return list;
	}
	
	
	/**
	 * 자판기 상품 구매하기
	 * */
	public int ordersInsert(int menuCode, String vmNo, int qty) throws SQLException{
		int result = ordersDao.ordersInsert(menuCode, vmNo, qty);
		if(result == 0) {
			throw new SQLException("주문 실패입니다.");
		}
		return result;
	}
	
		
	/**
	 * 상품별 매출 보기
	 * */
	public List<Orders> printMenuSalesSelect() throws SQLException{
		List<Orders> list = ordersDao.printMenuSalesSelect();
		if(list.isEmpty()) {
			throw new SQLException("판매 내역이 없습니다.");
		}
		return list;
	}
	
	/**
	 * 월별 매출 보기
	 * */
	public List<Orders> printMonthSalesSelect(String saleDate) throws SQLException{
		List<Orders> list = ordersDao.printMonthSalesSelect(saleDate);
		if(list.size()==0) {
			throw new SQLException("자판기번호를 확인해주세요.");
		}
		return list;
	}
	
}
