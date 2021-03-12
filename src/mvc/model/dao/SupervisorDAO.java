package mvc.model.dao;

import java.sql.SQLException;

import mvc.model.dto.Supervisor;

public interface SupervisorDAO {
	/** 최훈석
	 * 관리자로 로그인하기
	 * */
	Supervisor login(String svId, int password)throws SQLException;
	
}
