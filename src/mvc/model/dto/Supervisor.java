package mvc.model.dto;

public class Supervisor {
	private String svId;
	private int password;
	
	public Supervisor(String svId, int password) {
		super();
		this.svId = svId;
		this.password = password;
	}

	public String getSvId() {
		return svId;
	}

	public void setSvId(String svId) {
		this.svId = svId;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return svId + " | " + password;
	}
	
	
}
