package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;

public interface VMDAO {
	/**
	 * 관리하는 자판기 상태 자판기테이블 속성 조회하기
	 * */
	List<VendingMachine> selectVmBySvId (String svId) throws SQLException;
	
	
	/**
	 * 자판기 번호와 지점 보여주기
	 * */
	List<VendingMachine> selectVm() throws SQLException;
	
	
	/**
	 * 자판기 번호 체크
	 * */
	VendingMachine checkVmNo(String vmNo) throws SQLException;
}
