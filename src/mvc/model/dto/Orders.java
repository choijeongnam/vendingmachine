package mvc.model.dto;

public class Orders {
	private int orderSeq;
	private int menuCode;
	private String vmNo;
	private int qty;
	private int totalPrice;
	private String saleDate;
	private Menu menu;
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Orders(int orderSeq, int menuCode, String vmNo, int qty, int totalPrice, String saleDate) {
		super();
		this.orderSeq = orderSeq;
		this.menuCode = menuCode;
		this.vmNo = vmNo;
		this.qty = qty;
		this.totalPrice = totalPrice;
		this.saleDate = saleDate;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	@Override
	public String toString() {
		return orderSeq + "  |   " + menuCode + "  |   " + vmNo + "    |   " + qty
				+ "|" + totalPrice + " |" + saleDate;
	}
	
	
	
}
