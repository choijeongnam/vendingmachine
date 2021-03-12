package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;

public interface GoodsDAO {
	/**
	 * 지점 별 메뉴보여주기
	 * */
	List<Goods> goodsSelect(String vmNo) throws SQLException;
	
	/**
	 * 메뉴 등록하기
	 * */
	
	/**
	 * 재고 보충하기
	 * */
	
	/**
	 * 재고 확인하기
	 * */
}
