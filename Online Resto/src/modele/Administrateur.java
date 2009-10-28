package modele;


public class Administrateur implements Role{

	private String loginName; 
	private String password; 
	private String infoDuDude;
	
	public Administrateur(String loginName, String password, String infoDuDude) {
		this.loginName = loginName;
		this.password = password;
		this.infoDuDude = infoDuDude;
	}
	


	
}
