package mvc.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Orders;
import mvc.model.service.OrdersService;
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
}
