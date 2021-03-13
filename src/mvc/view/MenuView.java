package mvc.view;

import java.util.Scanner;

import mvc.model.controller.GoodsController;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //세션 메소드 생성
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
				//제품구매
				break;
			case 2 : 
				MenuView.supervisorLogin();//관리자 로그인
				break;
			case 9 : 
				System.exit(0);//프로그램 종료
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("▶ 샐러드 자판기 ◀");
		System.out.println("▶ 원하시는 항목을 선택해주세요 ◀");
		System.out.println("1. 구매   |   2. 관리자 로그인   |  9. 종료");
	}
	
	
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
		}
	}
	
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
	
	
}
