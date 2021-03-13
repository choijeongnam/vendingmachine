package mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.model.dto.Supervisor;
import mvc.util.DBUtil;

public class SupervisorDAOImpl implements SupervisorDAO{

	/**
	 * 관리자 로그인
	 * */
	@Override
	public Supervisor login(String svId, int password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Supervisor supervisor = null;
		String sql = "select * from Supervisor where sv_id=? and password=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, svId);
			ps.setInt(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				supervisor = new Supervisor(rs.getString(1), rs.getInt(2));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return supervisor;
	}

}
