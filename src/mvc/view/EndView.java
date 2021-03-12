package mvc.view;

import java.util.List;

import mvc.model.dto.Goods;

public class EndView {

	public static void printStock(List<Goods> list) {
		System.out.println("상품개수 : "+list.size()+"\n");
		
		System.out.println("자판기번호 | 메뉴코드 | 재고 수");
		for(Goods goods :list) {
			System.out.print("   "+goods.getVmNo()+"\t");
			System.out.print("\t"+goods.getMenuCode()+"\t");
			System.out.println("   "+goods.getStock());
		}
		System.out.println();
	}

}
