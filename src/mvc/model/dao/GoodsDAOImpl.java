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
		String sql = "select goods.VM_NO, goods.MENU_CODE, menu.MENU_NAME, menu.PRICE, menu.kcal, goods.stock \r\n"
				+ "from goods join menu \r\n"
				+ "on goods.menu_code = menu.menu_code and upper(goods.vm_no) = upper(?)";
		try {
			con = DBUtil.getConnection();
			ps  = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			while(rs.next()) {				

				VMGoods goods = new VMGoods(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
				
				
				goodsList.add(goods);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return goodsList;
	}
	
	@Override
	public List<Goods> selectStock(String vmNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select menu_code, vm_no, stock from goods where upper(vm_no)=upper(?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(goods);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
		
	}

	/**
	 * 재고 보충하기
	 * */
	@Override
	public int stockInsert(Goods goods) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update goods set stock = stock+? where vm_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goods.getStock());
			ps.setString(2, goods.getVmNo());
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int menuOnvmDelete(Goods goods) throws SQLException, NumberFormatException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from goods where menu_code = ? and upper(vm_no) = upper(?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, goods.getMenuCode());
			ps.setString(2, goods.getVmNo());
			/*if() {
			throw new NumberFormatException("메뉴코드를 확인해주세요.");
			}*/
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 메뉴 등록
	 * */
	@Override
	public int goodsInsert(String vm, int menuCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into goods values(GOODS_SEQ.NEXTVAL, ?, ?, 10)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, menuCode);
			ps.setString(2, vm);
			if(duplicateByMenuCode(vm, menuCode)) {
				throw new SQLException("이미 존재하는 메뉴입니다.");
			}
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
	public boolean duplicateByMenuCode(String vm,int menuCode) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql= "select menu_code from goods where menu_code = ? and vm_no = ?";
		ResultSet rs = null;
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, menuCode);
			ps.setString(2, vm);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return result;
	}
	
	public VMGoods vmGoodselect(Connection con,int menuCode, String vmNo) throws SQLException{
		VMGoods good = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		String sql = "select stock from goods where menu_code = ? and upper(vm_no) = upper(?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, menuCode);
			ps.setString(2, vmNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				good = new VMGoods(null, 0, null, 0, 0, rs.getInt(1));
			}
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return good;
	}

}
