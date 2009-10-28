package modele;


public class Gerant implements Role{

	private String loginName; 
	private String password; 
	private String infoDuDude;
	
	public Gerant(String loginName, String password, String infoDuDude) {
		this.loginName = loginName;
		this.password = password;
		this.infoDuDude = infoDuDude;
	}
	


	
}
