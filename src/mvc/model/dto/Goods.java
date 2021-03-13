package mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Goods {
	private int goodsSeq;
	private int menuCode;
	private String vmNo;
	private int stock;
	private List<Menu> menuList = new ArrayList<Menu>();
	
	public Goods(int menuCode, String vmNo, int stock) {
		this.menuCode = menuCode;
		this.vmNo = vmNo;
		this.stock =stock;
	}
	

	public int getGoodsSeq() {
		return goodsSeq;
	}

	public void setGoodsSeq(int goodsSeq) {
		this.goodsSeq = goodsSeq;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getVmNo() {
		return vmNo;
	}

	public void setVmNo(String vmNo) {
		this.vmNo = vmNo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	

	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	@Override
	public String toString() {
		return goodsSeq + " | " + menuCode + " | " + vmNo + " | " + stock;
	}
	
	
}
