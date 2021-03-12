package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.util.DBUtil;

public class GoodsDAOImpl implements GoodsDAO {

	@Override
	public List<Goods> goodsSelect(String vmNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		String sql = "select goods.VM_NO, menu.MENU_NAME, menu.PRICE, menu.kcal, goods.stock from goods join menu on goods.menu_code = menu.menu_code and goods.vm_no = ?";
		try {
			con = DBUtil.getConnection();
			ps  = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Menu menu = new Menu(0, rs.getString(2), rs.getInt(3), rs.getInt(4));
				
				Goods goods = new Goods(0, 0, rs.getString(1), rs.getInt(5), menu);
				new Goods
				goodsList.add(goods);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return goodsList;
	}

}
