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
	
	/**
	 * 관리자가 주문내역 보기
	 * */
	public static void printOrderList() {
		try {
		ordersService.printOrderList();
		EndView.printMessage("출력되었습니다.");
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
	
	
	/**
	 * 자판기 상품 구매하기
	 * */
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
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 월별 매출 조회
	 * */
	public static void printMonthSalesSelect(String saleDate) {
		try {
			List<Orders> list = ordersService.printMonthSalesSelect(saleDate);
			EndView.printMonthSalesList(list);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
