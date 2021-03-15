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
			System.out.println(ss.getSet()); //���� �޼ҵ� ����
			
			System.out.println("\t\t**** ������ ���Ǳ� ****");
			System.out.println("\t\t**** �׸� ���� ****");
			System.out.println("1.������ ���� \t | 2. ������ �α��� \t | 9. ����");
			System.out.print("�Է�> ");
			
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
		System.out.print("���̵�: ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		int password = Integer.parseInt(sc.nextLine());
		SupervisorController.login(id, password);
	}
	
	public static void printSupervisorMenu(String id) {
		while(true) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\t\t\t----"+id+"�� �α��� ��----");
		System.out.println("1. �α׾ƿ�  |  2. �ֹ�����Ȯ��  |  3. ���Ȯ��  |  4. �����  ");
		System.out.println("|  5. ���Ǳ⺰����  |  6. ��ǰ������  |  7. �ϸ���  |  8. �޴����  |  9. �޴�����");
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
	 * �α׾ƿ�
	 * */
	public static void logout(String svId) {
		Session session = new Session(svId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}
	
	/**
	 * �����
	 * */
	public static void printStockInsert(String svId) {
		System.out.println("������ ���Ǳ� ��ȣ: ");
		String vmNo = sc.nextLine();
		
		System.out.println("������ ��� ��: ");
		int stock = Integer.parseInt(sc.nextLine());
		
		Goods goods = new Goods(0, vmNo, stock);
		GoodsController.stockInsert(goods);
	}
	
	/**
	 * �޴����
	 * */
	public static void printGoodsInset(String svId) {
		
	}
	
	/**
	 * ���Ȯ��
	 * */
	public static void printStock(String svId) {
		try {
			System.out.print("��� Ȯ���� ���Ǳ� ��ȣ: ");
			String vmNo = sc.nextLine();
			GoodsController.selectStock(vmNo);
		}catch(NumberFormatException ne) {
			printStock(svId);
		}
	}
	
	/**
	 * �޴�����
	 * */
	public static void deleteMenu(String svId) {
		
		try {
		System.out.print("������ �޴� �ڵ� : ");
		int menuCode = Integer.parseInt(sc.nextLine());
		System.out.print("���Ǳ� ��ȣ: ");
		String vmNo = sc.nextLine();
		Goods goods = new Goods(menuCode, vmNo, 0);
		GoodsController.menuOnvmDelete(goods);
		}catch(NumberFormatException e) {
			System.out.println("�޴��ڵ�� ���ڸ� �Է��ϼ���");
			
			deleteMenu(svId);
		}
		
	}
	
}
