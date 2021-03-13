package mvc.view;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsDAO g = new GoodsDAOImpl();
		try {
		Goods gg= g.goodsSelect("A03");
		System.out.println(gg +"|"+ gg.getMenuList());
		
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	
	public void test11() {
		System.out.println("test");
	}
}
