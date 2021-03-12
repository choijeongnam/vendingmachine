package mvc.model.controller;

import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.service.GoodsService;
import mvc.view.EndView;
import mvc.view.FailView;

public class GoodsController {
	static GoodsService goodsService = new GoodsService();
	
	/**
	 * ���Ȯ��
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
	 * ��� ����
	 * */
	public static void goodsInsert(Goods goods) {
		try {
			goodsService.goodsInsert(goods);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
