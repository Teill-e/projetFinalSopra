package projetArmee.projetArmeeBack.restcontrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetArmee.projetArmeeBack.entities.Admin;
import projetArmee.projetArmeeBack.entities.Compte;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthentificationRestController {

//	@GetMapping("/admin")
//	@JsonView(JsonViews.Admin.class)
//	public Admin authentificationAdmin(@AuthenticationPrincipal Admin admin) {
//		return admin;
//	}
	
	@GetMapping("")
	@JsonView(JsonViews.Compte.class)
	public Compte authentificationJoueur(@AuthenticationPrincipal Compte Compte) {
		return Compte;
	}
	
}
