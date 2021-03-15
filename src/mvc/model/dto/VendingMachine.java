package mvc.model.dto;

public class VendingMachine {
	private String vmNo;
	private String loc;
	private String company;
	private String modelName;
	private String svId;
	
	public VendingMachine(String vmNo) {
		this.vmNo = vmNo;
	}
	
	public VendingMachine(String vmNo, String loc) {
		this(vmNo);
		this.loc = loc;
	}
	
	public VendingMachine(String vmNo, String loc, String company, String modelName, String svId) {
		this(vmNo, loc);
		this.company = company;
		this.modelName = modelName;
		this.svId = svId;
	}

	public String getVmNo() {
		return vmNo;
	}

	public void setVmNo(String vmNo) {
		this.vmNo = vmNo;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSvId() {
		return svId;
	}

	public void setSvId(String svId) {
		this.svId = svId;
	}

	@Override
	public String toString() {
		return vmNo + " | " + loc + " | " + company + " | " + modelName
				+ " | " + svId;
	}
	
	
}
