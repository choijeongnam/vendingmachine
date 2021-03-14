package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.dto.VendingMachine;
import mvc.util.DBUtil;

public class VMDAOImpl implements VMDAO{
	public List<VendingMachine> selectVmByVmId (String vmId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<VendingMachine> list = new ArrayList<VendingMachine>();
		 try {
		   con = DBUtil.getConnection();
		   ps= con.prepareStatement("select * from orders where vm_id=?");
		   ps.setString(1, vmId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	VendingMachine vm  = new VendingMachine(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
	        	
	        	
	        	list.add(vm);
	        }
  }finally {
  	DBUtil.dbClose(con, ps, rs);
  }
		return list;
	}

	@Override
	public List<VendingMachine> selectVm() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VendingMachine vm = null;
		List<VendingMachine> vmList = new ArrayList<VendingMachine>();
		String sql = "select VM_NO, LOC from VM";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vm = new VendingMachine(rs.getString(1), rs.getString(2));
				
				vmList.add(vm);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return vmList;
	}
}
