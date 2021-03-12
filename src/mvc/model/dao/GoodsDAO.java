package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;

public interface GoodsDAO {
	/** ������
	 * ���� �� �޴������ֱ�
	 * */
	List<VMGoods> goodsSelect(String vmNo) throws SQLException;
	
	/** ������
	 * �޴� ����ϱ�
	 *���Ǳ⺰�� ����� �ؾ��ؼ�
	 *�޴����� ����ͼ� ��� �μ�Ʈ�� ������ؿ�
	 * */
	
	
	/** ���Ƽ�
	 * ��� �����ϱ�
	 * �������̺����� ������Ʈ ���ָ� �˴ϴ�.
	 * update set stock(stock +) from goods where ? = ��޴� ? = � ���Ǳ�
	 * */
	

	/** �����
	 * ��� Ȯ���ϱ�
	 * �������̺��� ��� ��ü ��ȸ�ϱ� �̰Ŵ� ���ξ��ϼŵǺ��
	 * select  ���Ǳ��ȣ, name, stock  
	 * from goods where ���Ǳ��ȣ = ?
	 * */
	
	/** �����
	 * goods�� menu ���̺��� �ΰ��ε�
	 * ������� �� menu�� �մ� �� ��ǰ�� ���شٴ� ������
	 * �ƴϸ� goods�� �մ� ��ǰ�� ���ٴ� ������
	 * delete from goods where ���Ǳ��ȣ = ? and menuname =?	 
	 * */
	
	
	
	
	
	
	
}
