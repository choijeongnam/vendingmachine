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
	
	
	/**
	 * �����ڰ� �޴� Ȯ���ϱ�
	 * */
	public static void menuSelect() {
		try {
			List<Menu> list = menuService.menuSelect();
			EndView.printMenuSelect(list);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	

	/**
	 * ���Ǳ� �޴� �����ֱ�
	 * */
	public static void goodsSelect(String vmNo) {
		try {
			List<Menu> list = menuService.goodsSelect(vmNo);
			EndView.printGoods(list);
		}catch(SQLException e) {
			System.out.println("���ſ���");
			FailView.errorMessage(e.getMessage());
		}
	}
}
