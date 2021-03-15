package mvc.model.controller;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dto.VendingMachine;
import mvc.model.service.VMService;
import mvc.view.EndView;
import mvc.view.FailView;

public class VMController {
	static VMService vmService = new VMService();
	
	public static void selectVm() {
		try{
			List<VendingMachine> vmList = vmService.selectVm();
			EndView.printVm(vmList);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
