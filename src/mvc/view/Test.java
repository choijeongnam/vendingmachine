package mvc.view;

import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.GoodsDAO;
import mvc.model.dao.GoodsDAOImpl;
import mvc.model.dto.Goods;
import mvc.model.dto.VMGoods;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsDAO g = new GoodsDAOImpl();
		try {
		List<VMGoods> gg= g.goodsSelect("A03");
		for(VMGoods ggg :gg) {
			System.out.println(ggg);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
public void aa() {
			System.out.println("dd");
		}
}
