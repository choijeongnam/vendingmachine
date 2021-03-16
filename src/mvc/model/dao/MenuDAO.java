package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.dto.Orders;


public interface MenuDAO {
	
	/** 
	 * 상품별 매출 보기
	 * */
	List<Menu> printMenuSalesSelect() throws SQLException;
}
