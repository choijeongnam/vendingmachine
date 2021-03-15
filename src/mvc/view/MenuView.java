package mvc.view;

import java.util.Scanner;

import mvc.model.controller.GoodsController;
import mvc.model.controller.SupervisorController;
import mvc.session.Session;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
<<<<<<< HEAD
	public static void menu() {
=======
	public static void printMenu() {
		int menu = 0;
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
		while(true) {

			SessionSet ss = SessionSet.getInstance();
<<<<<<< HEAD
			System.out.println(ss.getSet()); //세션 메소드 생성
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
=======
			System.out.println(ss.getSet());

			System.out.println("\t\t**** 샐러드 자판기 ****");
			System.out.println("\t\t**** 항목 선택 ****");
			System.out.println("1.샐러드 구매 \t | 2. 관리자 로그인 \t | 9. 종료");
			System.out.print("입력> ");
			menu = Integer.parseInt(sc.nextLine());
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
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
	
<<<<<<< HEAD
	
	public static void printSupervisorMenu(String svId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set객체
			System.out.println("-----" +svId+ " 로그인 중 -----");
			System.out.println(" 1.재고확인 |  2.재고 보충  |  3.자판기별 매출 확인  | 4.제품별 매출 확인  |  5.일 별 매출 확인 |  6.상품 등록 | "
					+ "7.상품 삭제 | 8. 상품 정보수정 | 9. 총 판매내역보기 ");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
			case 1 : 
				GoodsController.selectStock(svId);
				break;
			case 2 : 
				GoodsController.goodsInsert(null);
				break;
			case 3 :
				//GoodsController.check???();
				
			case 4 :
				//GoodsController.check???();
				
			case 5 : 
				//GoodsController.check???();
				
			case 6 : 
				//GoodsController.menuInsert();
				
			case 7 : 
				GoodsController.menuOnvmDelete(null);
				break;
				
			case 8 :
				//GoodsController.menuUpdate();
				
			case 9 :
				//GoodsController.checkTotal();
			}
=======
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
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
		}
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
	/**
	 * 관리자 로그인 메뉴
	 * */
	public static void supervisorLogin() {
		System.out.println("관리자 아이디 : ");
		String svId = sc.nextLine();
		
		System.out.println("관리자 비밀번호 : ");
		String svPassword = sc.nextLine();
		
		//SupervisorController.login(svId, svPassword);
	}
	
	/**
	 * 자판기별 매출
	 * */
	
	
	/**
	 * 제품별 매출
	 * */
	
	
	/**
	 * 일별 매출
	 * */
	
	
	/**
	 * 총 매출
	 * */
	
	
=======
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
=======
	
	
	/**
	 * 로그아웃
	 * */
	public static void logout(String svId) {
		Session session = new Session(svId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
}
