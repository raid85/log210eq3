package modele;

public class Usager {

	String loginName, password, infoDuDude;

	public Usager(String loginName, String password, String infoDuDude) {
		
		this.loginName = loginName;
		this.password = password;
		this.infoDuDude = infoDuDude;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfoDuDude() {
		return infoDuDude;
	}

	public void setInfoDuDude(String infoDuDude) {
		this.infoDuDude = infoDuDude;
	}

	
	
	

}
