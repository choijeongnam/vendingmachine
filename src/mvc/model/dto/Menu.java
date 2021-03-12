package mvc.model.dto;

public class Menu {
	private int menuCode;
	private String menuName;
	private int price;
	private int kcal;
	
	public Menu(){};
	public Menu(int menuCode, String menuName, int price, int kcal) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.price = price;
		this.kcal = kcal;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
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

	@Override
	public String toString() {
		return menuCode + " | " + menuName + " | " + price + " | " + kcal;
	}
	
	
}
