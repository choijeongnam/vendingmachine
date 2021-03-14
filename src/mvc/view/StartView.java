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
		 *             **00자판기 입니다**
		 * 				메뉴를 선택해주세요
		 * 				1. 제품 구매 2. 관리자 로그인 9. 시스템 종료
		 * 			
		 * 				1번 선택 시
		 * 				지점을 선택해주세요
		 *				1. 강남 2. 서초 3. 용인 
		 *				
		 *				그 지점의 자판기 메뉴 보여주기
		 *				제품이름:
		 *				수량입력:
		 *
		 *				제품의 재고 없습니다. 초기화면으로 돌아갑니다.
		 *				
		 *				있을 경우
		 *				구매 완료하였습니다.
		 *				초기화면으로 돌아갑니다.
		 * 
		 *
		 *				2번 선택 시
		 *				아이디와 비밀번호를 입력해주세요
		 *				아이디:
		 *				비밀번호:
		 *				
		 *				아이디 비밀번호가 틀립니다.
		 *				초기화면으로 돌아갑니다.
		 *
		 *				제대로 입력 시
		 *				로그인되었습니다.
		 *
		 *				1. 재고 보기 
		 *  			2. 재고 보충하기 
		 *				3. 자판기별매출보기(여태까지 해당 자판기에서 팔렸던 총 제품과 해당 자판기 매출액)
		 *				4. 제품별매출보기(여태까지 그 제품수량 몇개 팔렷고 총 매출액)
		 *				5. 일매출보기(전체 sysdate 그 날짜에 해당하는 판매기록을 콘솔로)
		 *				6. 상품 등록하기 
		 *				7. 상품 삭제하기
		 *				8. 상품 정보 수정하기
		 *				9. 판매내역보기(전체내역을 보여주는데 파일을 새로 생성해서 그 안에
		 *				내용을 담는거)
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
		System.out.println("삭제");
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
