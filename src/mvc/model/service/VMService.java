package mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.VMDAO;
import mvc.model.dao.VMDAOImpl;
import mvc.model.dto.VendingMachine;

public class VMService {
	VMDAO vmDAO = new VMDAOImpl();
	
	public List<VendingMachine> selectVm() throws SQLException{
		List<VendingMachine> vmList = vmDAO.selectVm();
		if(vmList.isEmpty()) {
			throw new SQLException("���ǱⰡ �������� �ʽ��ϴ�.");
		}
		return vmList;
	}
	
	public VendingMachine checkVmNo(String vmNo) throws SQLException{
		VendingMachine vm = vmDAO.checkVmNo(vmNo);
		if(vm == null) {
			throw new SQLException("�ش� ���ǱⰡ �������� �ʽ��ϴ�.==> ....");
		}
		return vm;
	}
}
