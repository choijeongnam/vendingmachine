package mvc.model.controller;

import mvc.model.dto.Supervisor;
import mvc.model.service.SupervisorService;
import mvc.view.FailView;
import mvc.view.MenuView;

public class SupervisorController {
	static SupervisorService supervisorService = new SupervisorService();
	
	/**
	 * 로그인
	 * */
	public static void login(String svId, int Password) {
		try {
			Supervisor supervisor = supervisorService.login(svId, Password);
			// 보현님이 작성해주시는 printMenu 필요!!
			//MenuView.
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
