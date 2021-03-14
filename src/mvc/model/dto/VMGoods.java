package mvc.model.dto;

public class VMGoods {
	private String vmNo; 
	private int menuCode;
	private String menuName; 
	public int getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}
	private int price; 
	private int kcal; 
	private int stock;
	public VMGoods(String vmNo, int menuCode, String menuName, int price, int kcal, int stock) {
		super();
		this.vmNo = vmNo;
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.price = price;
		this.kcal = kcal;
		this.stock = stock;
	}
	public String getVmNo() {
		return vmNo;
	}
	public void setVmNo(String vmNo) {
		this.vmNo = vmNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return vmNo + " | " + menuCode + " | " + menuName + " | " + price + " | " + kcal + " | "
				+ stock;
	}
	
	
}
