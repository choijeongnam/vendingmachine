package mvc.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;

public interface GoodsDAO {
	/** 
	 * 지점 별 메뉴보여주기
	 * */
	List<VMGoods> goodsSelect(String vmNo) throws SQLException;
	
	
	/** 
	 * 메뉴 등록하기
	 * */
	int goodsInsert(String vm, int menuCode) throws SQLException;

	
	/** 
	 * 재고 보충하기
	 * */
	int stockInsert(Goods goods)throws SQLException;

	
	/** 
	 * 재고 확인하기
	 * */
	List<Goods> selectStock(String vmNo)throws SQLException;
	
	
	/**
	 * 자판기에 있는 메뉴 삭제하기(goods에 있는 메뉴) 
	 * */
	int menuOnvmDelete(Goods goods) throws SQLException; 
	
	
	/**
	 * 자판기별 해당상품 재고 보기
	 * */
	VMGoods vmGoodselect(Connection con,int menuCode, String vmNo) throws SQLException;
	
	
}
