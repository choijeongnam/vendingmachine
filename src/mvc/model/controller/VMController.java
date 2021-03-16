package mvc.model.controller;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;
import mvc.model.service.VMService;
import mvc.view.EndView;
import mvc.view.FailView;
import mvc.view.MenuView;

public class VMController {
	static VMService vmService = new VMService();
	
	/**
	 * ���Ǳ� ��ȣ�� ���� �����ֱ�
	 * */
	public static void selectVm() {
		try{
			List<VendingMachine> vmList = vmService.selectVm();
			EndView.printVm(vmList);		
			String checkVmNo = MenuView.inputVmNo();
			System.out.println();
			VendingMachine vm = vmService.checkVmNo(checkVmNo);
			GoodsController.goodsSelect(checkVmNo);
			System.out.println();
			MenuView.sellgoods(checkVmNo);
		}catch(SQLException e) {
			System.out.println("�ٽ� �Է����ֽʽÿ�.");
			VMController.selectVm();
		}
	}
	
	
	/**
	 * ���Ǳ� ��ȣ üũ
	 * */
	public static void checkVmNo(String checkVmNo) {
		try {
			VendingMachine vm = vmService.checkVmNo(checkVmNo);
		}catch(SQLException e){
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectVmBySvId() {
		try {
			List<VendingMachine> vmList = vmService.selectVmBySvId();
			EndView.printVmById(vmList);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
