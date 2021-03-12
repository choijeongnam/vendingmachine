package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;

public interface GoodsDAO {
	/**
	 * ���� �� �޴������ֱ�
	 * */
	List<VMGoods> goodsSelect(String vmNo) throws SQLException;
	
	/**
	 * �޴� ����ϱ�
	 *���Ǳ⺰�� ����� �ؾ��ؼ�
	 *�޴����� ����ͼ� ��� �μ�Ʈ�� ������ؿ�
	 * */
	
	
	/**
	 * ��� �����ϱ�
	 * �������̺����� ������Ʈ ���ָ� �˴ϴ�.
	 * update set stock(stock +) from goods where ? = ��޴� ? = � ���Ǳ�
	 * */
	

	/**
	 * ��� Ȯ���ϱ�
	 * �������̺��� ��� ��ü ��ȸ�ϱ� �̰Ŵ� ���ξ��ϼŵǺ��
	 * select  ���Ǳ��ȣ, name, stock  
	 * from goods
	 * */
	
	
	
	
	
	
}
