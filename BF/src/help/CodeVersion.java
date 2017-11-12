package help;

public class CodeVersion {

	private String version;
	private String code;
	
	public CodeVersion(String version,String code){
		this.version=version;
		this.code=code;
	}
	
	public String getVersion(){
		return this.version;
	}
	
	public String getCode(){
		return this.code;
	}
}

