package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;
import mvc.model.dto.VMGoods;

public class GoodsService {
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * ���Ȯ���ϱ�
	 * */
	public List<Goods> selectStock(String vmNo) throws SQLException{
		
		List<Goods> list  = goodsDAO.selectStock(vmNo);
		if(list.size()==0) {
			throw new SQLException(vmNo+" �� �ٽ� Ȯ�����ּ���.");
		}
		return list;
	}
	
	/**
	 * ��� �����ϱ�
	 * */
	public void stockInsert(Goods goods) throws SQLException{
		int result = goodsDAO.stockInsert(goods);
		if(result == 0) throw new SQLException("��� ���� ����");
	}
	
	/**
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�
	 * */
	public void menuOnvmDelete(Goods goods) throws SQLException{
		int result = goodsDAO.menuOnvmDelete(goods);
		if(result == 0) throw new SQLException("���Ǳ��� �޴��� �������� �ʾҽ��ϴ�.");
	}
	
	/**
	 * ���Ǳ� ���� �� ��ǰ �����ֱ�
	 * */
	public List<VMGoods> goodsSelect(String vmNo) throws SQLException{
		List<VMGoods> goodsList = goodsDAO.goodsSelect(vmNo);
		if(goodsList.isEmpty()) {
			throw new SQLException("�ش� ���ǱⰡ �������� �ʽ��ϴ�.");
		}
		return goodsList;
	}
}
