package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.JoueurService;

@RestController
@RequestMapping("/api/joueur")
public class JoueurRestController {

	@Autowired
	private JoueurService joueurSrv;
}
