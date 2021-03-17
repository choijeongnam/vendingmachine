package mvc.model.controller;

import java.sql.SQLException;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.service.GoodsService;
import mvc.view.EndView;
import mvc.view.FailView;

public class GoodsController {
	static GoodsService goodsService = new GoodsService();
	
	/**
	 * 재고확인
	 * */
	public static void selectStock(String vmNo) {
		try {
			List<Goods> list = goodsService.selectStock(vmNo);
			EndView.printStock(list);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 재고 보충
	 * */
	public static void stockInsert(Goods goods) {
		try {
			goodsService.stockInsert(goods);
			EndView.printMessage("재고가 보충되었습니다!");
			System.out.println();
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 자판기에 있는 메뉴 삭제하기
	 * */
	public static void menuOnvmDelete(Goods goods) {
		try {
			goodsService.menuOnvmDelete(goods);
			EndView.printMessage("해당 자판기에서 메뉴 삭제되었습니다!");
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * 메뉴 등록하기
	 * */
	public static void goodsInsert(String vmNo, int menuCode) {
		try {
			goodsService.goodsInsert(vmNo, menuCode);
			System.out.println("메뉴가 등록되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
