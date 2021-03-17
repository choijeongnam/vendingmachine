package mvc.model.service;

import java.sql.SQLException;

import java.util.List;

import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;

public class GoodsService {
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * ���Ȯ���ϱ�
	 * */
	public List<Goods> selectStock(String vmNo) throws SQLException{
		
		List<Goods> list  = goodsDAO.selectStock(vmNo);
		if(list.size()==0) {
			throw new SQLException("���Ǳ� ��ȣ�� �ٽ� Ȯ�����ּ���.");
		}
		return list;
	}
	
	/**
	 * ��� �����ϱ�
	 * */
	public void stockInsert(Goods goods) throws SQLException{
		int result = goodsDAO.stockInsert(goods);
		if(result == 0) throw new SQLException("�ش� ���Ǳ⿡ ��ǰ�� �����ϴ�.");
	}
	
	/**
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�
	 * */
	public void menuOnvmDelete(Goods goods) throws SQLException{
		int result = goodsDAO.menuOnvmDelete(goods);
		if(result == 0) throw new SQLException("���Ǳ��� �޴��� �������� �ʾҽ��ϴ�.\n�޴��ڵ峪 ���Ǳ��ȣ�� Ȯ�����ּ���.");
		
	}
	
	
	
	/**
	 * �޴� ����ϱ�
	 * */
	public void goodsInsert(String vmNo, int menuCode) throws SQLException{
		int result = goodsDAO.goodsInsert(vmNo, menuCode);
		if(result == 0) throw new SQLException("�޴������ �Ҽ� �����ϴ�.");
	}
}
