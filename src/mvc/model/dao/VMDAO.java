package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;

public interface VMDAO {
	/**
	 * �����ϴ� ���Ǳ� ���� ���Ǳ����̺� �Ӽ� ��ȸ�ϱ�
	 * select 
	 * */
	List<VendingMachine> selectVmBySvId () throws SQLException;
	
	/**
	 * ���Ǳ� ��ȣ�� ���� �����ֱ�
	 * */
	List<VendingMachine> selectVm() throws SQLException;
	
	/**
	 * ���Ǳ� ��ȣ üũ �޼ҵ�
	 * */
	VendingMachine checkVmNo(String vmNo) throws SQLException;
}
