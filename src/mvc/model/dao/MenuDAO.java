package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Menu;


public interface MenuDAO {
	/**
	 * 메뉴 보여주기
	 * */
	List<Menu> goodsSelect() throws SQLException;
	
	/**
	 * 메뉴 검색하기 
	 * */
}
