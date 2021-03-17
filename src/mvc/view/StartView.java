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

		MenuView.printMenu();

	}

}
