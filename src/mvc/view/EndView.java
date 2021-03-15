package mvc.view;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.model.dto.VendingMachine;
import oracle.net.aso.g;

public class EndView {

	/**
	 * ���Ȯ���ϱ�
	 * */
	public static void printStock(List<Goods> list) {
		System.out.println("\n��ǰ���� : "+list.size());
		
		System.out.println("���Ǳ��ȣ | �޴��ڵ� | ��� ��");
		for(Goods goods :list) {
			System.out.print("   "+goods.getVmNo()+"     |");
			System.out.print("    "+goods.getMenuCode()+"   |");
			System.out.println("   "+goods.getStock());
		}
		System.out.println();
	}



	/**
	 * ���Ǳ⺰ ���� ��ȸ
	 * */
	public static void printVmSalesList(List<Orders> list) {
		System.out.println("���Ǳ⺰ ���� Ȯ���ϱ�");
		System.out.println("���Ǳ��ȣ   "+"|   �� �Ǹž�   |"+"   �� �ǸŰ���");
		for(Orders orders : list) {
			System.out.print(orders.getVmNo() + "\t\t    ");
			System.out.print(orders.getTotalPrice() + "             ");
			System.out.println(orders.getQty());
		}
	}



	public static void printMessage(String message) {
		System.out.println(message);
		
	}



	public static void printGoods(List<VMGoods> goodsList) {
		System.out.println(" �޴��ڵ� |    ��ǰ��    | ���� |Į�θ�|���");
		for(VMGoods goods :goodsList) {
			System.out.println(" "+goods.getMenuCode()+" |"+goods.getMenuName()+"|"+goods.getPrice()+"|"+goods.getKcal()+"|"+goods.getStock());
		}
	}
	/**
	 * �Ϻ� ���� ��ȸ
	 * */
	public static void printDaySalesList(List<Orders> list) {
		System.out.println("�Ϻ� ���� Ȯ���ϱ�");
		System.out.println("    ��¥    "+"|   �� �Ǹž�   |"+"  �� �ǸŰ���");
		for(Orders orders : list) {
			System.out.print(orders.getSaleDate()+"  |    ");
			System.out.print(orders.getTotalPrice()+"      |    ");
			System.out.println(orders.getQty());
		}
	}



	public static void printVm(List<VendingMachine> vmList) {
		for(VendingMachine vm : vmList) {
			System.out.println(vm.getVmNo() +"  |  "+vm.getLoc());
		}
		
	}
	
	/**
	 * ���Ǳ� ���� ��ȸ(endview)
	 * */
	public static void printVmById(List<VendingMachine> vmList) {
		System.out.println("���Ǳ� ���� ��ȸ");
		System.out.println("���Ǳ� ��ȣ" + " | ��ġ" + " | ������" + " | �𵨸�");
		
		for(VendingMachine vm : vmList) {
			System.out.println(vm.getVmNo() +" | "+ vm.getLoc() +" | " + vm.getCompany() + " | " + vm.getModelName());
		}
		
		
	}
}
