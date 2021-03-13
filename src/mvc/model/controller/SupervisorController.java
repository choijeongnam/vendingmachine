package mvc.model.controller;

import mvc.model.dto.Supervisor;
import mvc.model.service.SupervisorService;
import mvc.view.FailView;
import mvc.view.MenuView;

public class SupervisorController {
	static SupervisorService supervisorService = new SupervisorService();
	
	/**
	 * �α���
	 * */
	public static void login(String svId, int Password) {
		try {
			Supervisor supervisor = supervisorService.login(svId, Password);
			// �������� �ۼ����ֽô� printMenu �ʿ�!!
			//MenuView.
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
