package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;

public interface GoodsDAO {
	/** 최정남
	 * 지점 별 메뉴보여주기
	 * */
	List<VMGoods> goodsSelect(String vmNo) throws SQLException;
	
	/** 최정남
	 * 메뉴 등록하기
	 *자판기별로 등록을 해야해서
	 *메뉴에서 갖고와서 굿즈를 인설트를 해줘야해요
	 * */
	
	
	/** 최훈석
	 * 재고 보충하기
	 * 굿즈테이블에서만 업데이트 해주면 됩니다.
	 * update set stock(stock +) from goods where ? = 어떤메뉴 ? = 어떤 자판기
	 * */
	

	/** 우수현
	 * 재고 확인하기
	 * 굿즈테이블에서 재고 전체 조회니까 이거는 조인안하셔되빈다
	 * select  자판기번호, name, stock  
	 * from goods where 자판기번호 = ?
	 * */
	
	/** 우수현
	 * goods랑 menu 테이블이 두개인데
	 * 삭제라는 게 menu에 잇는 그 상품을 없앤다는 것인지
	 * 아니면 goods에 잇는 상품을 뺀다는 것인지
	 * delete from goods where 자판기번호 = ? and menuname =?	 
	 * */
	
	
	
	
	
	
	
}
