package modele;


public class Livreur implements Role{

	private String loginName; 
	private String password; 
	private String infoDuDude;
	
	public Livreur(String loginName, String password, String infoDuDude) {
		this.loginName = loginName;
		this.password = password;
		this.infoDuDude = infoDuDude;
	}
	


	
}
