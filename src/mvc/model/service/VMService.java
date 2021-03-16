package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.VMDAO;
import mvc.model.dao.VMDAOImpl;
import mvc.model.dto.VendingMachine;

public class VMService {
	VMDAO vmDAO = new VMDAOImpl();
	
	/**
	 * 자판기 정보 조회(VMService)
	 * */
	public List<VendingMachine> selectVmBySvId () throws SQLException {
		VMDAO vmDAO = new VMDAOImpl();
		List<VendingMachine> vmList = vmDAO.selectVmBySvId();
		if(vmList.isEmpty()) {
			throw new SQLException("해당 관리자가 관리하는 자판기는 없습니다.");
		}
		return vmList;
	
	}
	
	
	/**
	 * 자판기 번호와 지점 보여주기
	 * */
	public List<VendingMachine> selectVm() throws SQLException{
		List<VendingMachine> vmList = vmDAO.selectVm();
		if(vmList.isEmpty()) {
			throw new SQLException("자판기가 존재하지 않습니다.");
		}
		return vmList;
	}
	
	
	/**
	 * 자판기 번호 체크
	 * */
	public VendingMachine checkVmNo(String vmNo) throws SQLException{
		VendingMachine vm = vmDAO.checkVmNo(vmNo);
		if(vm == null) {
			throw new SQLException("해당 자판기가 존재하지 않습니다.==> ....");
		}
		return vm;
	}
}
