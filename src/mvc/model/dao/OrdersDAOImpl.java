package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Menu;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.util.DBUtil;

public class OrdersDAOImpl implements OrdersDAO {
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * 자판기 상품 구매하기
	 * */
	@Override
	public int ordersInsert(int menuCode, String vmNo, int qty) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO ORDERS(ORDER_SEQ , MENU_CODE, VM_NO, QTY, TOTAL_PRICE, SALE_DATE)"
		  		+ "VALUES(ORDER_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
		int result=0;
		try {
			
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
		   
			ps = con.prepareStatement(sql);
			if(qty == 0) {throw new SQLException("수량 0개를 입력하셨습니다. 다시 입력해주십시오");}
			ps.setInt(1, menuCode);
			ps.setString(2, vmNo);
			ps.setInt(3, qty);
			ps.setInt(4, qty*getTotalAmount(menuCode));
		  
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("주문 실패...");   
		   }
			   //주문수량만큼 재고량 감소하기
		   int stockResult = decrementStock(con, menuCode, vmNo, qty);
		   if(result == 0) {
			   con.rollback();
			   throw new SQLException("재고량 부족으로 구매하실 수 없습니다.");
		   }
		   con.commit();
		   }finally {
			   con.commit();
			   DBUtil.dbClose(con, ps, null);
		   }
		return result;
	}
	
	/**
	 * 선택한 메뉴의 총 가격
	 * */
	public int getTotalAmount(int menuCode) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		String sql = "select price from menu where menu_code = ?";
		ResultSet rs = null;
		int price = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, menuCode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				price = rs.getInt(1);
			}else {
				throw new SQLException("없는 메뉴입니다.");
			}
		}finally{
			DBUtil.dbClose(null, ps, rs);
		}
		return price;
	}
	
	/**
	 * 재고량 감소
	 * */
	public int decrementStock(Connection con ,int menuCode, String vmNo, int qty) throws SQLException{
		PreparedStatement ps=null;
		String sql = "update goods set stock=stock-? where menu_code = ? and vm_no = ?";
		VMGoods good = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, menuCode);
			ps.setString(3, vmNo);
			
			good = goodsDAO.vmGoodselect(con, menuCode, vmNo);
			if(good.getStock() < qty) {
				throw new SQLException("남은 재고가 없습니다.");
			}
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(null, ps);
		}
		return result;
	}


	/**
	 * 관리자가 주문내역 보기
	 * */
	@Override
	public List<Orders> printOrderList() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Orders orders = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String sql = "select * from Orders order by order_seq";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				orders = new Orders(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				
				orderList.add(orders);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return orderList;
	}


	/**
	 * 자판기별 매출 보기
	 * */
	@Override
	public List<Orders> printVmSalesSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select vm_no, sum(total_price) as 총판매액, sum(qty) as 총판매개수 from orders group by vm_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String vmNo = rs.getString("vm_no");
				int totalPrice = rs.getInt("총판매액");
				int qty = rs.getInt("총판매개수");
				
				Orders orders = new Orders(0, 0, vmNo, qty, totalPrice, null);
				
				list.add(orders);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}


	/**
	 * 일별 매출 보기
	 * */
	@Override
	public List<Orders> printDaySalesSelect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select to_char(to_date(sale_date), 'yyyy-mm-dd') 날짜, sum(total_price) 일매출, sum(qty) 총판매개수 "
				+ "from orders group by sale_date";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String saleDate = rs.getString("날짜");
				int totalPrice = rs.getInt("일매출");
				int qty = rs.getInt("총판매개수");
			
				Orders orders = new Orders(0, 0, null, qty, totalPrice, saleDate);
				list.add(orders);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}



	/**
	 * 월별 매출 보기
	 * */
	@Override
	public List<Orders> printMonthSalesSelect(String saleDate) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select vm_no, sum(total_price) 월매출, sum(qty) 총판매개수 \r\n"
				+ "from orders \r\n"
				+ "where to_char(to_date(sale_date), 'yyyy-mm') = ?\r\n"
				+ "group by vm_no \r\n"
				+ "order by vm_no";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, saleDate);
			rs= ps.executeQuery();
			while(rs.next()) {
				String vmNo = rs.getString("vm_no");
				int totalPrice = rs.getInt("월매출");
				int qty = rs.getInt("총판매개수");
				
				Orders orders = new Orders(0, 0, vmNo, qty, totalPrice, null);
				list.add(orders);
			}
		}finally {
			
		}
		return list;
	}
	
	
}
