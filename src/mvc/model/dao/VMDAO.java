package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;

public interface VMDAO {
	/**
	 * ����
	 * �����ϴ� ���Ǳ� ���� ���Ǳ����̺� �Ӽ� ��ȸ�ϱ�
	 * select 
	 * */
	List<VendingMachine> selectVmByVmId (String vmId) throws SQLException;
	
	
	List<VendingMachine> selectVm() throws SQLException;
	
	VendingMachine checkVmNo(String vmNo) throws SQLException;
}
