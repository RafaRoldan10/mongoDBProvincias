package mongoDB.model;

public class Ccaa {
	
	
	private String parent_code;
	private String label;
	private String code;
	public Ccaa() {
		super();
	}
	
	
	@Override
	public String toString() {
		return label;
	}


	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
