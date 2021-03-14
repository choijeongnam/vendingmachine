package mvc.view;

import java.util.Scanner;

import mvc.model.controller.GoodsController;
import mvc.model.controller.SupervisorController;
import mvc.session.Session;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		int menu = 0;
		while(true) {

			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());

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
		
	}


	public static void login() {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		int password = Integer.parseInt(sc.nextLine());
		SupervisorController.login(id, password);
	}
	
	public static void printSupervisorMenu(String id) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\t\t\t----"+id+"님 로그인 중----");
		System.out.println("1. 로그아웃  |  2. 주문내역확인  |  3. 재고확인  |  4. 재고보충  |  5. 자판기별매출  |  6. 제품별매출  |  7. 일매출  |  8. 메뉴등록");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			logout(id);
			return;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
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
}
