package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		  		+ "VALUES(ORDERS_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
		  int result=0;
		 try {
			
		   con = DBUtil.getConnection();
		   con.setAutoCommit(false);
		   
		   ps = con.prepareStatement(sql);
		   ps.setInt(1, menuCode);
		   ps.setString(2, vmNo);
		   ps.setInt(3, qty);
		   ps.setInt(4, qty*getTotalAmount(menuCode));
		   if(qty == 0) {throw new SQLException("���� 0���� �Է��ϼ̽��ϴ�. �ٽ� �Է����ֽʽÿ�");}
		   result = ps.executeUpdate();
		   if(result==0) {
			   con.rollback();
			   throw new SQLException("�ֹ� ����...");   
		   }
			   //�ֹ�������ŭ ��� �����ϱ�
		   result = decrementStock(con, menuCode, vmNo, qty);
		   if(result == 0) {
				  con.rollback();
				  throw new SQLException("��� �������� �����Ͻ� �� �����ϴ�.");
			  }
		   con.commit();
		  
		
		   }finally {
		    	  con.commit();
		      	DBUtil.dbClose(con, ps, null);
		      }
		 return 0;
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
				throw new SQLException("���� �޴��Դϴ�.");
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
				throw new SQLException("���� ��� �����ϴ�.");
			}
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(null, ps);
		}
		return result;
	}
	
}
