package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.MenuDAO;
import mvc.model.dao.MenuDAOImpl;
import mvc.model.dto.Menu;

public class MenuService {
	MenuDAO menuDAO = new MenuDAOImpl();
	
	/**
	 * ��ǰ�� ���� ����
	 * */
	public List<Menu> printMenuSalesSelect() throws SQLException{
		List<Menu> menuList = menuDAO.printMenuSalesSelect();
		if(menuList.size() == 0) {
			throw new SQLException("��ǰ�� ���� ����� �����ϴ�.");
		}
		return menuList;
	}
	
	
	/**
	 * �����ڰ� �޴� Ȯ���ϱ�
	 * */
	public List<Menu> menuSelect() throws SQLException{
		List<Menu> list = menuDAO.menuSelect();
		if(list.size() == 0) {
			throw new SQLException("�޴��� �����ϴ�.");
		}
		return list;
	}
	
	/**
	 * ���Ǳ⺰ �޴�����
	 * */
	public List<Menu> goodsSelect(String vmNo) throws SQLException{
		List<Menu> list = menuDAO.goodsSelect(vmNo);
		if(list.size() == 0) {
			throw new SQLException("�ش� ���ǱⰡ �������� �ʽ��ϴ�.");
		}
		return list;
	}
	
}
