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
	 * ����
	 * �����ϴ� ���Ǳ� ���� ���Ǳ����̺� �Ӽ� ��ȸ�ϱ�
	 * select 
	 * */

	

}
