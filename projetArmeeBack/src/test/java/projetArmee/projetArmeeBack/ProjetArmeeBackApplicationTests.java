package projetArmee.projetArmeeBack;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projetArmee.projetArmeeBack.entities.Admin;
import projetArmee.projetArmeeBack.entities.Arme;
import projetArmee.projetArmeeBack.entities.Armee;
import projetArmee.projetArmeeBack.entities.ArmeeAir;
import projetArmee.projetArmeeBack.entities.ArmeeTerre;
import projetArmee.projetArmeeBack.entities.Composition;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.Marine;
import projetArmee.projetArmeeBack.entities.Partie;
import projetArmee.projetArmeeBack.entities.Pays;
import projetArmee.projetArmeeBack.entities.TypeA;
import projetArmee.projetArmeeBack.entities.Unite;
import projetArmee.projetArmeeBack.services.ArmeService;
import projetArmee.projetArmeeBack.services.ArmeeService;
import projetArmee.projetArmeeBack.services.CompositionService;
import projetArmee.projetArmeeBack.services.CompteService;
import projetArmee.projetArmeeBack.services.PartieService;
import projetArmee.projetArmeeBack.services.UniteService;

@SpringBootTest
class ProjetArmeeBackApplicationTests {

	@Autowired
	CompteService compteSrv;
	@Autowired
	ArmeeService armeeSrv;
	@Autowired
	ArmeService armeSrv;
	@Autowired
	UniteService uniteSrv;

	@Autowired
	PartieService partieSrv;
	
	@Autowired
	CompositionService compositionSrv;

	@Test
	void contextLoads() {
	}

	@Test
	void ajoutCompte() {
		Joueur j = new Joueur("joueur", "joueur");
		Admin admin = new Admin("admin", "admin");
		compteSrv.create(j);
		compteSrv.create(admin);
		Arme arme1 = new Arme(TypeA.fusil_de_precision);
		Arme arme2 = new Arme(TypeA.fusil_dassaut);

		Arme arme3 = new Arme(TypeA.mine);
		Arme arme4 = new Arme(TypeA.mitraillette);
		armeSrv.create(arme1);
		armeSrv.create(arme2);
		armeSrv.create(arme3);
		armeSrv.create(arme4);

		Set<Arme> armes = new HashSet<>();
		armes.add(arme1);
		armes.add(arme2);

		Armee armee1 = new ArmeeAir(100, Pays.Australie);
		Armee armee2 = new ArmeeTerre(100, Pays.Australie);
		Armee armee3 = new Marine(100, Pays.Australie);

		Unite unite1 = new Unite(armes, 500, armee1);
		Unite unite2 = new Unite(armes, 500, armee2);
		
		
		Unite unite3 = new Unite(armes, 500, armee1);
		Unite unite4 = new Unite(armes, 500, armee2);
		
		Set<Unite> unites = new HashSet();
		Collections.addAll(unites,unite1,unite2);
		
		Set<Unite> unites2 = new HashSet();
		Collections.addAll(unites2,unite3,unite4);

		armeeSrv.create(armee1);
		armeeSrv.create(armee2);
		armeeSrv.create(armee3);
		uniteSrv.create(unite2);
		uniteSrv.create(unite1);
		uniteSrv.create(unite3);
		uniteSrv.create(unite4);
		
		Composition compoJ = new Composition(unites,500);
		Composition compoIA = new Composition(unites2,700);
		
		compositionSrv.create(compoJ);
		compositionSrv.create(compoIA);
		
		
		Partie partie = new Partie(LocalDate.now(),false,j,compoJ,compoIA);
		
		partieSrv.create(partie);
		
		
		
	}

}
