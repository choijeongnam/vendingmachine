package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Supervisor;

public interface SupervisorDAO {
	/** ���Ƽ�
	 * �����ڷ� �α����ϱ�
	 * */
	Supervisor login(String svId, int password)throws SQLException;
	
}
