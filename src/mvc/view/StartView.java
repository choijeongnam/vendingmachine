package mvc.view;

import java.sql.SQLException;
import java.util.List;

import mvc.model.controller.GoodsController;
import mvc.model.controller.OrdersController;
import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dao.OrdersDAO;
import mvc.model.dao.OrdersDAOImpl;
import mvc.model.dto.Goods;
import mvc.model.dto.Orders;
import mvc.model.dto.VMGoods;
import mvc.model.service.OrdersService;

public class StartView {

	public static void main(String[] args) {
<<<<<<< HEAD
		 MenuView.menu();
		 System.out.println("-----------");
=======

<<<<<<< HEAD
		MenuView.printMenu();
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
=======
		//MenuView.printMenu();
>>>>>>> branch 'master' of https://github.com/choijeongnam/vendingmachine.git
		/*
		 *             **00���Ǳ� �Դϴ�**
		 * 				�޴��� �������ּ���
		 * 				1. ��ǰ ���� 2. ������ �α��� 9. �ý��� ����
		 * 			
		 * 				1�� ���� ��
		 * 				������ �������ּ���
		 *				1. ���� 2. ���� 3. ���� 
		 *				
		 *				�� ������ ���Ǳ� �޴� �����ֱ�
		 *				��ǰ�̸�:
		 *				�����Է�:
		 *
		 *				��ǰ�� ��� �����ϴ�. �ʱ�ȭ������ ���ư��ϴ�.
		 *				
		 *				���� ���
		 *				���� �Ϸ��Ͽ����ϴ�.
		 *				�ʱ�ȭ������ ���ư��ϴ�.
		 * 
		 *
		 *				2�� ���� ��
		 *				���̵�� ��й�ȣ�� �Է����ּ���
		 *				���̵�:
		 *				��й�ȣ:
		 *				
		 *				���̵� ��й�ȣ�� Ʋ���ϴ�.
		 *				�ʱ�ȭ������ ���ư��ϴ�.
		 *
		 *				����� �Է� ��
		 *				�α��εǾ����ϴ�.
		 *
		 *				1. ��� ���� 
		 *  			2. ��� �����ϱ� 
		 *				3. ���Ǳ⺰���⺸��(���±��� �ش� ���Ǳ⿡�� �ȷȴ� �� ��ǰ�� �ش� ���Ǳ� �����)
		 *				4. ��ǰ�����⺸��(���±��� �� ��ǰ���� � �ȷǰ� �� �����)
		 *				5. �ϸ��⺸��(��ü sysdate �� ��¥�� �ش��ϴ� �Ǹű���� �ַܼ�)
		 *				6. ��ǰ ����ϱ� 
		 *				7. ��ǰ �����ϱ�
		 *				8. ��ǰ ���� �����ϱ�
		 *				9. �Ǹų�������(��ü������ �����ִµ� ������ ���� �����ؼ� �� �ȿ�
		 *				������ ��°�)
		 * 
		 * 
		 * 
		 * */
		
		//GoodsController.selectStock("A01");
		//Goods goods = new Goods(200, "A01", 0);
		//GoodsController.menuOnvmDelete(goods);
		/*
		OrdersDAO dao =new OrdersDAOImpl();
		try {
		int result =dao.ordersInsert(100, "A01", 3);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		*/

		/*
		GoodsDAO dao = new GoodsDAOImpl();
		Goods goods = new Goods(200, "A03", 0);
		try {
			dao.menuOnvmDelete(goods);
		System.out.println("����");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		*/

		//OrdersController.printVmSalesSelect();
		
		OrdersDAO dao = new OrdersDAOImpl();
		try {
		List<Orders> list=dao.printVmSalesSelect();
		for(Orders o :list) {
			System.out.println(o);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
