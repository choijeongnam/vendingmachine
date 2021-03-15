package mvc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface VMDAO {
	/**
	 * 보현
	 * 관리하는 자판기 상태 자판기테이블 속성 조회하기
	 * select 
	 * */
	public List<Vm> selectVmByVmId (String vmId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Vm> list = new ArrayList<>();
		 try {
		   con = DbUtil.getConnection();
		   ps= con.prepareStatement("select * from orders where vm_id=?");
		   ps.setString(1, vmId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Vm vm  = new Vm(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
	        	
	        	
	        	list.add(vm);
	        }
  }finally {
  	DbUtil.close(con, ps, rs);
  }
		return list;
	}
}
