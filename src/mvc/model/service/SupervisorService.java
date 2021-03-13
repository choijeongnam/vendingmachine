package mvc.model.service;

import java.sql.SQLException;

import mvc.model.dao.SupervisorDAO;
import mvc.model.dao.SupervisorDAOImpl;
import mvc.model.dto.Supervisor;
import mvc.model.exception.NotFoundException;
import mvc.session.Session;
import mvc.session.SessionSet;

public class SupervisorService {
	SupervisorDAO supervisorDAO = new SupervisorDAOImpl();
	
	/**
	 * �α���
	 * */
	public Supervisor login(String svId, int password) throws NotFoundException, SQLException{
		Supervisor supervisor = supervisorDAO.login(svId, password);
		if(supervisor == null) {
			throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.");
		}
		
		Session session = new Session(svId);
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.add(session);
		
		return supervisor;
	}
}
