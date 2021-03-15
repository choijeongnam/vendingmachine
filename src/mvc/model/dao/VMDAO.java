package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;

public interface VMDAO {
	/**
	 * 보현
	 * 관리하는 자판기 상태 자판기테이블 속성 조회하기
	 * select 
	 * */
	List<VendingMachine> selectVmByVmId (String vmId) throws SQLException;
	
	
	List<VendingMachine> selectVm() throws SQLException;
	
	VendingMachine checkVmNo(String vmNo) throws SQLException;
}
