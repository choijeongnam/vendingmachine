package mvc.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.Orders;
import mvc.util.DBUtil;

public class MenuDAOImpl implements MenuDAO {
	
	/**
	 * 제품별 매출 보기
	 * */
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

	
	/**
	 * 관리자가 메뉴 확인하기
	 * */
	@Override
	public List<Menu> menuSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		String sql = "select menu_code, menu_name, price, kcal from menu";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(menu);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 지점별메뉴보여주기
	 * */
	@Override
	public List<Menu> goodsSelect(String vmNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		String sql = "SELECT MENU.MENU_CODE, MENU.MENU_NAME, menu.PRICE, menu.kcal, goods.stock\r\n"
				+ "FROM MENU JOIN GOODS\r\n"
				+ "ON MENU.MENU_CODE = GOODS.MENU_CODE AND UPPER(GOODS.vm_no) = upper(?) order by goods.menu_code";
		try {
			con = DBUtil.getConnection();
			ps  = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			while(rs.next()) {				
					
				int menuCode = rs.getInt(1);
					Menu menu = new Menu(menuCode, rs.getString(2), rs.getInt(3), rs.getInt(4));
					
					Goods goods = new Goods(menuCode, vmNo, rs.getInt(5));
					
					menu.setGoods(goods);
					
					list.add(menu);
			}
		}finally {
				DBUtil.dbClose(con, ps, rs);
		}
			return list;
	}

}
