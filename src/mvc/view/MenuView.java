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
			System.out.println(ss.getSet()); //���� �޼ҵ� ����
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
=======
			System.out.println(ss.getSet());

			System.out.println("\t\t**** ������ ���Ǳ� ****");
			System.out.println("\t\t**** �׸� ���� ****");
			System.out.println("1.������ ���� \t | 2. ������ �α��� \t | 9. ����");
			System.out.print("�Է�> ");
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
		System.out.print("���̵�: ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		int password = Integer.parseInt(sc.nextLine());
		SupervisorController.login(id, password);
	}
	
<<<<<<< HEAD
	
	public static void printSupervisorMenu(String svId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +svId+ " �α��� �� -----");
			System.out.println(" 1.���Ȯ�� |  2.��� ����  |  3.���Ǳ⺰ ���� Ȯ��  | 4.��ǰ�� ���� Ȯ��  |  5.�� �� ���� Ȯ�� |  6.��ǰ ��� | "
					+ "7.��ǰ ���� | 8. ��ǰ �������� | 9. �� �Ǹų������� ");
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
		System.out.println("\t\t\t----"+id+"�� �α��� ��----");
		System.out.println("1. �α׾ƿ�  |  2. �ֹ�����Ȯ��  |  3. ���Ȯ��  |  4. �����  |  5. ���Ǳ⺰����  |  6. ��ǰ������  |  7. �ϸ���  |  8. �޴����");
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
	 * ������ �α��� �޴�
	 * */
	public static void supervisorLogin() {
		System.out.println("������ ���̵� : ");
		String svId = sc.nextLine();
		
		System.out.println("������ ��й�ȣ : ");
		String svPassword = sc.nextLine();
		
		//SupervisorController.login(svId, svPassword);
	}
	
	/**
	 * ���Ǳ⺰ ����
	 * */
	
	
	/**
	 * ��ǰ�� ����
	 * */
	
	
	/**
	 * �Ϻ� ����
	 * */
	
	
	/**
	 * �� ����
	 * */
	
	
=======
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
=======
	
	
	/**
	 * �α׾ƿ�
	 * */
	public static void logout(String svId) {
		Session session = new Session(svId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
}
