package mvc.model.dao;

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
	 *자판기별로 등록을 해야해서
	 *메뉴에서 갖고와서 굿즈를 인설트를 해줘야해요
	 * */
	
	
	/**
	 * 재고 보충하기
	 * 굿즈테이블에서만 업데이트 해주면 됩니다.
	 * update set stock(stock +) from goods where ? = 어떤메뉴 ? = 어떤 자판기
	 * */
	

	/**
	 * 재고 확인하기
	 * 굿즈테이블에서 재고 전체 조회니까 이거는 조인안하셔되빈다
	 * select  자판기번호, name, stock  
	 * from goods
	 * */
	
	
	
	
	
	
}
