package mvc.model.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.OrdersDAO;
import mvc.model.dao.OrdersDAOImpl;
import mvc.model.dto.Orders;

public class OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	
	public void printOrderList(List<Orders> orderList) throws SQLException, IOException{
		orderList = ordersDao.printOrderList();
		
		try{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/mvc.view/�ֹ�������.txt")));
			for(Orders orders : orderList) {
				String print = orders.toString();
				bw.write(print);
			}
			bw.flush();
			bw.close();
		}catch(IOException e) {
			throw new IOException("���� �����Դϴ�."); //�޼��� ����� �����ؾ�����
		}
	}
}
