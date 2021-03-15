package mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mvc.model.controller.GoodsController;
import mvc.model.controller.OrdersController;
import mvc.model.controller.SupervisorController;
import mvc.model.controller.VMController;
import mvc.model.dto.Goods;
import mvc.model.service.VMService;
import mvc.session.Session;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		int menu = 0;
		while(true) {

			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //세션 메소드 생성
			
			System.out.println("\t\t**** 샐러드 자판기 ****");
			System.out.println("\t\t**** 항목 선택 ****");
			System.out.println("1.샐러드 구매 \t | 2. 관리자 로그인 \t | 9. 종료");
			System.out.print("입력> ");
			
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				customerService();
				break;
			case 2:
				login();
				break;
			case 9:
				System.exit(0);
			}
		}
	}
	
	
	private static void customerService() {
		


		VMController.selectVm();
		
		
	}


	public static void login() {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		int password = Integer.parseInt(sc.nextLine());
		SupervisorController.login(id, password);
	}
	
	public static void printSupervisorMenu(String id) {
		while(true) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\t\t\t----"+id+"님 로그인 중----");
		System.out.println("1. 로그아웃  |  2. 주문내역확인  |  3. 재고확인  |  4. 재고보충  ");
		System.out.println("|  5. 자판기별매출  |  6. 제품별매출  |  7. 일매출  |  8. 메뉴등록  |  9. 메뉴삭제");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
			case 1:
				logout(id);
				return;
			case 2:
				OrdersController.printOrderList();
				break;
			case 3:
				printStock(id);
				break;
			case 4:
				printStockInsert(id);
				break;
			case 5:
				OrdersController.printVmSalesSelect();
				break;
			case 6:
				
				break;
			case 7:
				OrdersController.printDaySalesSelect();
				break;
			case 8:
				
				break;
			case 9:
				deleteMenu(id);
				break;
			}
		}
	}
	
	
	/**
	 * 로그아웃
	 * */
	public static void logout(String svId) {
		Session session = new Session(svId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}
	
	/**
	 * 재고보충
	 * */
	public static void printStockInsert(String svId) {
		System.out.println("보충할 자판기 번호: ");
		String vmNo = sc.nextLine();
		
		System.out.println("보충할 재고 량: ");
		int stock = Integer.parseInt(sc.nextLine());
		
		Goods goods = new Goods(0, vmNo, stock);
		GoodsController.stockInsert(goods);
	}
	
	/**
	 * 메뉴등록
	 * */
	public static void printGoodsInset(String svId) {
		
	}
	
	/**
	 * 재고확인
	 * */
	public static void printStock(String svId) {
		try {
			System.out.print("재고를 확인할 자판기 번호: ");
			String vmNo = sc.nextLine();
			GoodsController.selectStock(vmNo);
		}catch(NumberFormatException ne) {
			printStock(svId);
		}
	}
	
	/**
	 * 메뉴삭제
	 * */
	public static void deleteMenu(String svId) {
		
		try {
		System.out.print("삭제할 메뉴 코드 : ");
		int menuCode = Integer.parseInt(sc.nextLine());
		System.out.print("자판기 번호: ");
		String vmNo = sc.nextLine();
		Goods goods = new Goods(menuCode, vmNo, 0);
		GoodsController.menuOnvmDelete(goods);
		}catch(NumberFormatException e) {
			System.out.println("메뉴코드는 숫자만 입력하세요");
			
			deleteMenu(svId);
		}
		
	}
	
}
