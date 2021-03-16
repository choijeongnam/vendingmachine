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
	
	/**
	 * 관리하는 자판기 상태 자판기테이블 속성 조회하기
	 * */
	public List<VendingMachine> selectVmBySvId (String svId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<VendingMachine> list = new ArrayList<VendingMachine>();
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement("select * from orders where vm_id=?");
			ps.setString(1, svId);
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

	/**
	 * 자판기 번호와 지점 보여주기
	 * */
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
	
	
	/**
	 * 자판기 번호 체크
	 * */
	@Override
	public VendingMachine checkVmNo(String vmNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select vm_no from vm where upper(vm_no)= upper(?)";
		VendingMachine vm = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vmNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				vm = new VendingMachine(vmNo);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return vm;
	}
}
