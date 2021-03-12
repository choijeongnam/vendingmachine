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
}
