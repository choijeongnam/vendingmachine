package mvc.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;


public interface VMDAO {

	List<VendingMachine> selectVm() throws SQLException;
	List<VendingMachine> selectVmByVmId(String vmId) throws SQLException;
	/**
	 * 보현
	 * 관리하는 자판기 상태 자판기테이블 속성 조회하기
	 * select 
	 * */

	

}
