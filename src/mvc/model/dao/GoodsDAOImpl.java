package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Goods;
import mvc.model.dto.Menu;
import mvc.model.dto.VMGoods;
import mvc.util.DBUtil;

public class GoodsDAOImpl implements GoodsDAO {

	@Override
	public List<VMGoods> goodsSelect(String vmNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<VMGoods> goodsList = new ArrayList<VMGoods>();
		String sql = "select goods.VM_NO, menu.MENU_NAME, menu.PRICE, menu.kcal, goods.stock from goods join menu on goods.menu_code = menu.menu_code and goods.vm_no = ?";
		try {
			con = DBUtil.getConnection();
			ps  = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {				
				VMGoods goods = new VMGoods( rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getInt(5));
				goodsList.add(goods);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return goodsList;
	}

	

}
