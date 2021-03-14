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
	
	public void printOrderList() throws SQLException, IOException{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/view/주문내역서.txt"))){
			List<Orders> orderList = ordersDao.printOrderList();
			bw.write("\t\t\t==== 주문내역서 ====");
			bw.write("\r\n");
			bw.write("\r\n");
			
			for(Orders orders : orderList) {
				String print = orders.toString();
				bw.write("\t"+print);
				bw.write("\r\n"); 
			}
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace(); //메세지 뭐라고 전달해야할지
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
	 * 주문 넣기
	 */
	/**
	 * 일별 매출 조회
	 * */
	public List<Orders> printDaySalesSelect() throws SQLException{
		List<Orders> list = ordersDao.printDaySalesSelect();
		if(list.size() == 0) throw new SQLException("판매 내역이 없습니다.");
		return list;
	}
	
	public int ordersInsert(int menuCode, String vmNo, int qty) throws SQLException{
		int result = ordersDao.ordersInsert(menuCode, vmNo, qty);
		if(result == 0) {
			throw new SQLException("주문 실패입니다.");
		}
		return result;
	}
	
}
