package mvc.view;

import java.util.Scanner;

import mvc.model.controller.SupervisorController;
import mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		int menu = 0;
		while(true) {

			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());

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
		
		
	}


	public static void login() {
		System.out.print("���̵�: ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		int password = Integer.parseInt(sc.nextLine());
		SupervisorController.login(id, password);
	}
	
	public static void printSupervisorMenu(String id) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\t\t\t----"+id+"�� �α��� ��----");
		System.out.println("1. �α׾ƿ�  |  2. Ȯ��  | 3. ...");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}
}
