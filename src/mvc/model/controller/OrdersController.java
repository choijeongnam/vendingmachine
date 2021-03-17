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
	 * �����ڰ� �ֹ����� ����
	 * */
	public static void printOrderList() {
		try {
		ordersService.printOrderList();
		EndView.printMessage("��µǾ����ϴ�.");
		}catch(IOException e) {
			FailView.errorMessage(e.getMessage());
		}catch(SQLException e1) {
			FailView.errorMessage(e1.getMessage());
		}
	}
	
	
	/**
	 * ���Ǳ⺰ ���� ��ȸ
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
	 * ���Ǳ� ��ǰ �����ϱ�
	 * */
	public static void ordersInsert(int menuCode, String vmNo, int qty) {
		try {
			ordersService.ordersInsert(menuCode, vmNo, qty);
			EndView.printMessage("���ŵǾ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * �Ϻ� ���� ��ȸ
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
	 * ���� ���� ��ȸ
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
