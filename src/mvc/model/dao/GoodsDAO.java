package mvc.model.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;

public interface GoodsDAO {
	
	
	/** 
	 * �޴� ����ϱ�
	 * */
	int goodsInsert(String vm, int menuCode) throws SQLException;

	
	/** 
	 * ��� �����ϱ�
	 * */
	int stockInsert(Goods goods)throws SQLException;

	
	/** 
	 * ��� Ȯ���ϱ�
	 * */
	List<Goods> selectStock(String vmNo)throws SQLException;
	
	
	/**
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�(goods�� �ִ� �޴�) 
	 * */
	int menuOnvmDelete(Goods goods) throws SQLException; 
	
	
	/**
	 * ���Ǳ⺰ �ش��ǰ ��� ����
	 * */
	Goods Goodselect(Connection con,int menuCode, String vmNo) throws SQLException;
	
	
}
