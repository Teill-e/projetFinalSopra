package projetArmee.projetArmeeBack.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte{

	
	
	public Admin() {
	}

	public Admin(String login, String password) {
		super(login,password);
		
	}


	
}
