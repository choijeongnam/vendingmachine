package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;

public interface GoodsDAO {
	/**
	 * ���� �� �޴������ֱ�
	 * */
	List<Goods> goodsSelect(String vmNo) throws SQLException;
	
	/**
	 * �޴� ����ϱ�
	 * */
	
	/**
	 * ��� �����ϱ�
	 * */
	
	/**
	 * ��� Ȯ���ϱ�
	 * */
}
