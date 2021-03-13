package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;

public interface GoodsDAO {
	/** 
	 * ������
	 * ���� �� �޴������ֱ�
	 * */
	List<VMGoods> goodsSelect(String vmNo) throws SQLException;
	
	/** 
	 * ������
	 * �޴� ����ϱ�
	 *���Ǳ⺰�� ����� �ؾ��ؼ�
	 *�޴����� ����ͼ� ��� �μ�Ʈ�� ������ؿ�
	 * */
	int goodsInsert(String vm, int menuCode) throws SQLException;
	

	/** 
	 * ���Ƽ�
	 * ��� �����ϱ�
	 * �������̺����� ������Ʈ ���ָ� �˴ϴ�.
	 * update goods set stock = stock+? where vm_no = ?
	 * */
	int goodsInsert(Goods goods)throws SQLException;

	/** 
	 * �����
	 * ��� Ȯ���ϱ�
	 * �������̺��� ��� ��ü ��ȸ�ϱ� �̰Ŵ� ���ξ��ϼŵǺ��
	 * select  ���Ǳ��ȣ, name, stock  
	 * from goods where ���Ǳ��ȣ = ?
	 * 
	 * */
	List<Goods> selectStock(String vmNo)throws SQLException;
	
	/** 
	 * �����
	 * goods�� menu ���̺��� �ΰ��ε�
	 * ������� �� menu�� �մ� �� ��ǰ�� ���شٴ� ������
	 * �ƴϸ� goods�� �մ� ��ǰ�� ���ٴ� ������
	 * delete from goods where ���Ǳ��ȣ = ? and menuname =?
	 */
	
	/**
	 * ���Ǳ⿡ �ִ� �޴� �����ϱ�(goods�� �ִ� ��ǰ ���°�	) 
	 * delete from goods where menu_code = 200 and upper(vm_no) = upper(?)
	 * */
	int menuOnvmDelete(Goods goods) throws SQLException; 
	
	
	
	
	
	
	
	
	
	
	
}
