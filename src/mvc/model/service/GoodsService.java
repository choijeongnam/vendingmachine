package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;

public class GoodsService {
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * 재고확인하기
	 * */
	public List<Goods> selectStock(String vmNo) throws SQLException{
		
		List<Goods> list  = goodsDAO.selectStock(vmNo);
		if(list.size()==0) {
			throw new SQLException(vmNo+" 를 다시 확인해주세요.");
		}
		return list;
	}
	
	/**
	 * 재고 보충하기
	 * */
	public void goodsInsert(Goods goods) throws SQLException{
		int result = goodsDAO.goodsInsert(goods);
		if(result == 0) throw new SQLException("재고 보충 오류");
	}
	
	/**
	 * 자판기에 있는 메뉴 삭제하기
	 * */
	public void menuOnvmDelete(Goods goods) throws SQLException{
		int result = goodsDAO.menuOnvmDelete(goods);
		if(result == 0) throw new SQLException("자판기의 메뉴가 삭제되지 않았습니다.");
	}
}
