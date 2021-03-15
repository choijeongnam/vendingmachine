package mvc.model.controller;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.VMGoods;
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
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 재고 보충
	 * */
	public static void stockInsert(Goods goods) {
		try {
			goodsService.stockInsert(goods);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 자판기에 있는 메뉴 삭제하기
	 * */
	public static void menuOnvmDelete(Goods goods) {
		try {
			goodsService.menuOnvmDelete(goods);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 자판기 메뉴 보여주기
	 * */
	public static void goodsSelect(String vmNo) {
		try {
			List<VMGoods> goodsList = goodsService.goodsSelect(vmNo);
			EndView.printGoods(goodsList);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("구매오류");
			FailView.errorMessage(e.getMessage());
		}
	}
}
