package mvc.view;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.model.dto.VendingMachine;
import oracle.net.aso.g;

public class EndView {

	/**
	 * 재고확인하기
	 * */
	public static void printStock(List<Goods> list) {
		System.out.println("\n상품개수 : "+list.size());
		
		System.out.println("자판기번호 | 메뉴코드 | 재고 수");
		for(Goods goods :list) {
			
			System.out.print("   "+goods.getVmNo()+"     |");
			System.out.print("    "+goods.getMenuCode()+"   |");
			System.out.println("   "+goods.getStock());
			/*
			System.out.print("   "+goods.getVmNo()+"\t");
			System.out.print("\t"+goods.getMenuCode()+"\t");
			System.out.println("   "+goods.getStock());
			*/ 
			
		}
		System.out.println();
	}



	/**
	 * 자판기별 매출 조회
	 * */
	public static void printVmSalesList(List<Orders> list) {
		System.out.println("자판기별 매출 확인하기");
		System.out.println("자판기번호 "+"|   총 판매액   |"+"  총 판매개수");
		for(Orders orders : list) {
			/*
			System.out.print("    "+orders.getVmNo() + "    |      ");
			System.out.print(orders.getTotalPrice() + "    |   ");
			System.out.println("    "+orders.getQty());
			*/
			System.out.print("    "+orders.getVmNo() + "\t\t ");
			System.out.print(orders.getTotalPrice() + "\t");
			System.out.println("\t  "+orders.getQty());
			
		}
	}



	public static void printMessage(String message) {
		System.out.println(message);
		
	}



	public static void printGoods(List<VMGoods> goodsList) {
		System.out.println(" 메뉴코드 |    제품명    | 가격 | 칼로리 | 재고");
		for(VMGoods goods :goodsList) {
			System.out.println("    "+goods.getMenuCode()+"   |  "+goods.getMenuName()+"  | "+goods.getPrice()+" |  "+goods.getKcal()+"   |  "+goods.getStock());
		}
	}
	/**
	 * 일별 매출 조회
	 * */
	public static void printDaySalesList(List<Orders> list) {
		System.out.println("일별 매출 확인하기");
		System.out.println("     날짜     "+"|   총 판매액   |"+" 총 판매개수");
		for(Orders orders : list) {
			/*
			System.out.print("  "+orders.getSaleDate()+"  |    ");
			System.out.print(orders.getTotalPrice()+"      |    ");
			System.out.println(orders.getQty());
			*/
			System.out.print("  "+orders.getSaleDate()+"\t    ");
			System.out.print(orders.getTotalPrice()+"\t      ");
			System.out.println(orders.getQty());
		}
	}



	public static void printVm(List<VendingMachine> vmList) {
		for(VendingMachine vm : vmList) {
			System.out.println(vm.getVmNo() +"  |  "+vm.getLoc());
		}
		
	}
	
	/**
	 * 자판기 정보 조회(endview)
	 * */
	public static void printVmById(List<VendingMachine> vmList) {
		System.out.println("자판기 정보 조회");
		System.out.println("자판기 번호" + " | 모델명" + " | 지점위치" + " | 제조회사");
		
		for(VendingMachine vm : vmList) {
			System.out.println(vm.getVmNo() +"         | "+ vm.getModelName() +"   |   " + vm.getLoc() + "       | " + vm.getCompany());
		}
		
		
	}


	/**
	 * 제품별 매출 조회
	 * */
	public static void printMenuSalesList(List<Menu> menuList) {
		System.out.println("제품별 매출 확인하기");
		System.out.println("   메뉴이름 | 판매액 | 판매개수");
		for(Menu menu : menuList) {
			System.out.println("  "+menu.getMenuName() +"  " + menu.getOrders().getTotalPrice() + "     " + menu.getOrders().getQty());
		}
		
	}


	/**
	 * 월별 매출 조회
	 * */
	public static void printMonthSalesList(List<Orders> list) {
		System.out.println("월별 매출 확인하기");
		System.out.println("자판기번호 |  월매출  | 총 판매개수");
		for(Orders orders : list) {
			System.out.print("   "+orders.getVmNo()+"\t      ");
			System.out.print(orders.getTotalPrice()+"\t    ");
			System.out.println(orders.getQty());
		}
	}
	
}
