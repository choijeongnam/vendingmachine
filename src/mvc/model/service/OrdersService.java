package mvc.model.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mvc.model.dao.OrdersDAO;
import mvc.model.dao.OrdersDAOImpl;
import mvc.model.dto.Orders;

public class OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	
	public void printOrderList() throws SQLException, IOException{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/mvc/view/�ֹ�������.txt"))){
			List<Orders> orderList = ordersDao.printOrderList();
			bw.write("\t\t\t==== �ֹ������� ====");
			bw.write("\r\n");
			bw.write("\r\n");
			
			for(Orders orders : orderList) {
				String print = orders.toString();
				bw.write("\t"+print);
				bw.write("\r\n"); 
			}
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace(); //�޼��� ����� �����ؾ�����
		}
	}
}
