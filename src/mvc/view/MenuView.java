package mvc.view;

import java.util.Scanner;

import mvc.model.controller.GoodsController;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //���� �޼ҵ� ����
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 : 
				//��ǰ����
				break;
			case 2 : 
				MenuView.supervisorLogin();//������ �α���
				break;
			case 9 : 
				System.exit(0);//���α׷� ����
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("�� ������ ���Ǳ� ��");
		System.out.println("�� ���Ͻô� �׸��� �������ּ��� ��");
		System.out.println("1. ����   |   2. ������ �α���   |  9. ����");
	}
	
	
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
		}
	}
	
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
	
	
}
