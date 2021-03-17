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
	public static void stockInsert(Goods goods) {
		try {
			goodsService.stockInsert(goods);
			EndView.printMessage("��� ����Ǿ����ϴ�!");
			System.out.println();
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�
	 * */
	public static void menuOnvmDelete(Goods goods) {
		try {
			goodsService.menuOnvmDelete(goods);
			EndView.printMessage("�ش� ���Ǳ⿡�� �޴� �����Ǿ����ϴ�!");
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * �޴� ����ϱ�
	 * */
	public static void goodsInsert(String vmNo, int menuCode) {
		try {
			goodsService.goodsInsert(vmNo, menuCode);
			System.out.println("�޴��� ��ϵǾ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
