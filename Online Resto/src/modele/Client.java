package modele;

public class Client  {

	String loginName, password, infoDuDude;
	//Role droits = new Client;

	public Client(String loginName, String password, String infoDuDude) {
		
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

	public boolean compareTo(Client autreUsager){
		if(loginName.equals(autreUsager.getLoginName()) && password.equals(autreUsager.getPassword())){
			return true;
		}
		else	
		return false;
	}
	
	

}
