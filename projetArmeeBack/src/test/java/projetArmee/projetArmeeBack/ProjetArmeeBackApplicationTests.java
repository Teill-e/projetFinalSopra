package projetArmee.projetArmeeBack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projetArmee.projetArmeeBack.entities.Admin;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.services.CompteService;

@SpringBootTest
class ProjetArmeeBackApplicationTests {

	@Autowired 
	CompteService compteSrv;
	@Test
	void contextLoads() {
	}
	
	@Test
	void ajoutCompte()
	{
		Joueur j = new Joueur("joueur","joueur");
		Admin admin= new Admin("admin","admin");
		compteSrv.create(j);
		compteSrv.create(admin);
	}
}
