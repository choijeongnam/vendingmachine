package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.MenuDAO;
import mvc.model.dao.MenuDAOImpl;
import mvc.model.dto.Menu;

public class MenuService {
	MenuDAO menuDAO = new MenuDAOImpl();
	
	/**
	 * 제품별 매출 보기
	 * */
	public List<Menu> printMenuSalesSelect() throws SQLException{
		List<Menu> menuList = menuDAO.printMenuSalesSelect();
		if(menuList.size() == 0) {
			throw new SQLException("제품별 매출 기록이 없습니다.");
		}
		return menuList;
	}
	
	
	/**
	 * 관리자가 메뉴 확인하기
	 * */
	public List<Menu> menuSelect() throws SQLException{
		List<Menu> list = menuDAO.menuSelect();
		if(list.size() == 0) {
			throw new SQLException("메뉴가 없습니다.");
		}
		return list;
	}
	
	/**
	 * 자판기별 메뉴보기
	 * */
	public List<Menu> goodsSelect(String vmNo) throws SQLException{
		List<Menu> list = menuDAO.goodsSelect(vmNo);
		if(list.size() == 0) {
			throw new SQLException("해당 자판기가 존재하지 않습니다.");
		}
		return list;
	}
	
}
