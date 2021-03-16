package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.dto.Orders;
import mvc.util.DBUtil;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> printMenuSalesSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> menuList = new ArrayList<Menu>();
		String sql = "select m.menu_name, o.qty, o.total \r\n"
				+ "from menu m join (select menu_code, sum(total_price) total, sum(qty) qty from orders group by menu_code) o\r\n"
				+ "using(menu_code)";
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu(0, rs.getString(1), 0, 0);
				
				Orders order = new Orders(0, 0, null, rs.getInt(2), rs.getInt(3), null);
				
				menu.setOrders(order);
				
				menuList.add(menu);
			}
		}finally {
			
		}
		return menuList;
	}

}
