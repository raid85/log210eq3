package modele;

import java.util.Observable;
import java.util.Observer;

public class Usager extends Observable {

	String loginName, password, infoDuDude;
	Role droits;

	
	
	public Usager(String loginName, String password, String infoDuDude, Role droits) {
		
		this.loginName = loginName;
		this.password = password;
		this.infoDuDude = infoDuDude;
		this.droits=droits;
	}

	public void setUsager(Observer observateur) {
		
		addObserver(observateur);
		
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

	public Role getDroits() {
		return droits;
	}

	public void setDroits(Role droits) {
		this.droits = droits;
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

	public boolean compareTo(Usager autreUsager){
		if(loginName.equals(autreUsager.getLoginName()) && password.equals(autreUsager.getPassword())){
			return true;
		}
		else	
		return false;
	}
	
	

}
