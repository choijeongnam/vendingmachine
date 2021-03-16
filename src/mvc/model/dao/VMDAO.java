package mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;

public interface VMDAO {
	/**
	 * �����ϴ� ���Ǳ� ���� ���Ǳ����̺� �Ӽ� ��ȸ�ϱ�
	 * */
	List<VendingMachine> selectVmBySvId (String svId) throws SQLException;
	
	
	/**
	 * ���Ǳ� ��ȣ�� ���� �����ֱ�
	 * */
	List<VendingMachine> selectVm() throws SQLException;
	
	
	/**
	 * ���Ǳ� ��ȣ üũ
	 * */
	VendingMachine checkVmNo(String vmNo) throws SQLException;
}
