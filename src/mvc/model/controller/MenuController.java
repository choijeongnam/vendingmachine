package mvc.model.controller;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.service.MenuService;
import mvc.view.EndView;
import mvc.view.FailView;

public class MenuController {
	static MenuService menuService = new MenuService();
	
	public static void printMenuSalesSelect() {
		try {
			List<Menu> menuList = menuService.printMenuSalesSelect();
			EndView.printMenuSalesList(menuList);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
