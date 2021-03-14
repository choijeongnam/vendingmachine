package mvc.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Orders;
import mvc.model.service.OrdersService;
import mvc.view.EndView;
import mvc.view.FailView;

public class OrdersController {
	static OrdersService ordersService = new OrdersService();
	
	public static void printOrderList() {
		try {
		ordersService.printOrderList();
		}catch(IOException e) {
			FailView.errorMessage(e.getMessage());
		}catch(SQLException e1) {
			FailView.errorMessage(e1.getMessage());
		}
	}
	
	/**
	 * 자판기별 매출 조회
	 * */
	public static void printVmSalesSelect() {
		try {
			List<Orders> list = ordersService.printVmSalesSelect();
			EndView.printVmSalesList(list);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	

	public static void ordersInsert(int menuCode, String vmNo, int qty) {
		try {
			ordersService.ordersInsert(menuCode, vmNo, qty);
			EndView.printMessage("구매되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	/**
	 * 일별 매출 조회
	 * */
	public static void printDaySalesSelect() {
		try {
			List<Orders> list = ordersService.printDaySalesSelect();
			EndView.printDaySalesList(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
