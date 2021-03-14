package mvc.view;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.model.dto.VendingMachine;

public class EndView {

	/**
	 * 재고확인하기
	 * */
	public static void printStock(List<Goods> list) {
		System.out.println("\n상품개수 : "+list.size());
		
		System.out.println("자판기번호 | 메뉴코드 | 재고 수");
		for(Goods goods :list) {
			System.out.print("   "+goods.getVmNo()+"\t");
			System.out.print("\t"+goods.getMenuCode()+"\t");
			System.out.println("   "+goods.getStock());
		}
		System.out.println();
	}



	/**
	 * 자판기별 매출 조회
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
		System.out.println("       메뉴코드|   제품명   |  가격  |칼로리|재고");
		for(VMGoods goods :goodsList) {
			System.out.println(goods);
		}
	}
	/**
	 * 일별 매출 조회
	 * */
	public static void printDaySalesList(List<Orders> list) {
		System.out.println("일별 매출 확인하기");
		System.out.println("날짜       "+"|   총 판매액   |"+"  총 판매개수");
		for(Orders orders : list) {
			System.out.print(orders.getSaleDate()+"\t ");
			System.out.print(orders.getTotalPrice()+"\t\t");
			System.out.println(orders.getQty());
		}
	}



	public static void printVm(List<VendingMachine> vmList) {
		for(VendingMachine vm : vmList) {
			System.out.println(vm.getVmNo() +"  |  "+vm.getLoc());
		}
		
	}
	
}
