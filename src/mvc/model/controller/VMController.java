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
			System.out.println("다시 입력해주십시오.");
			VMController.selectVm();
		}
		
	}
	
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
			EndView.printVm(vmList);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
