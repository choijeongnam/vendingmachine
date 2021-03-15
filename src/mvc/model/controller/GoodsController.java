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
	 * ���Ȯ��
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
	 * ��� ����
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
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�
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
	 * ���Ǳ� �޴� �����ֱ�
	 * */
	public static void goodsSelect(String vmNo) {
		try {
			List<VMGoods> goodsList = goodsService.goodsSelect(vmNo);
			EndView.printGoods(goodsList);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("���ſ���");
			FailView.errorMessage(e.getMessage());
		}
	}
}
