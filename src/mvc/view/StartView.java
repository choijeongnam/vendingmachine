package mvc.view;

import java.sql.SQLException;
import java.util.List;

import mvc.model.controller.GoodsController;
import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;
import mvc.model.dto.VMGoods;

public class StartView {

	public static void main(String[] args) {
		 MenuView.menu();
		 System.out.println("-----------");
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
		
		
		
		
		
		
	
	
			// TODO Auto-generated method stub
			GoodsDAO g = new GoodsDAOImpl();
			try {
			List<VMGoods> goodsList= g.goodsSelect("A03");
			for(VMGoods goods : goodsList) {
				System.out.println(goods);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
	
	}

}
