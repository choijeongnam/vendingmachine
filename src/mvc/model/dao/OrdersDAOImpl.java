package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.util.DBUtil;

public class OrdersDAOImpl implements OrdersDAO {
	GoodsDAO goodsDAO = new GoodsDAOImpl();
	
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


	@Override
	public List<Orders> printOrderList() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Orders orders = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String sql = "select * from Orders";
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
	public List<Orders> printVmSalesList() throws SQLException {
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
				int totalPrice = rs.getInt("total_price");
				int qty = rs.getInt("qty");
				
				Orders orders = new Orders(0, 0, vmNo, qty, totalPrice, null);
				
				list.add(orders);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
}
