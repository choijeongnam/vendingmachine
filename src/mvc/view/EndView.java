package mvc.view;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;

public class EndView {

	/**
	 * ���Ȯ���ϱ�
	 * */
	public static void printStock(List<Goods> list) {
		System.out.println("��ǰ���� : "+list.size()+"\n");
		
		System.out.println("���Ǳ��ȣ | �޴��ڵ� | ��� ��");
		for(Goods goods :list) {
			System.out.print("   "+goods.getVmNo()+"\t");
			System.out.print("\t"+goods.getMenuCode()+"\t");
			System.out.println("   "+goods.getStock());
		}
		System.out.println();
	}



	/**
	 * ���Ǳ⺰ ���� ��ȸ
	 * */
	public static void printVmSalesList(List<Orders> list) {
		for(Orders orders : list) {
			System.out.println(orders);
		}
	}



	public static void printMessage(String message) {
		System.out.println(message);
		
	}



	public static void printGoods(List<VMGoods> goodsList) {
		for(VMGoods goods :goodsList) {
			System.out.println(goods);
		}
	}
	/**
	 * �Ϻ� ���� ��ȸ
	 * */
	public static void printDaySalesList(List<Orders> list) {
		System.out.println("�Ϻ� ���� Ȯ���ϱ�");
		for(Orders orders : list) {
			System.out.println(orders.getSaleDate());
		}
	}
	
}
