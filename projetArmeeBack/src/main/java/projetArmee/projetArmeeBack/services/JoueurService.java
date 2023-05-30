package projetArmee.projetArmeeBack.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.Partie;
import projetArmee.projetArmeeBack.exceptions.JoueurException;
import projetArmee.projetArmeeBack.repositories.JoueurRepository;
import projetArmee.projetArmeeBack.repositories.PartieRepository;



@Service
public class JoueurService {
	
	@Autowired
	private JoueurRepository joueurRepo;
	
	
	@Autowired
	private PartieRepository partieRepo;
	
	
	private void checkJoueur(Joueur Joueur) {
		if (Joueur == null) {
			throw new JoueurException("Joueur null");
		}
		if (Joueur.getLogin() == null || Joueur.getPassword() == null) {
			throw new JoueurException("informations manquantes");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new JoueurException("id null");
		}
	}

	public Joueur create(Joueur Joueur) {
		checkJoueur(Joueur);
		return joueurRepo.save(Joueur);
	}

	public Joueur update(Joueur Joueur) {
		Joueur JoueurEnBase = getById(Joueur.getId());
		checkJoueur(Joueur);
		JoueurEnBase.setLogin(Joueur.getLogin());
		JoueurEnBase.setPassword(Joueur.getPassword());
		JoueurEnBase.setListeParties(Joueur.getListeParties());
		
		return joueurRepo.save(JoueurEnBase);
	}

	public Joueur getById(Long id) {
		checkId(id);
		return joueurRepo.findById(id).orElseThrow(() -> {
			throw new JoueurException("id inconnu");
		});

}
	public List<Joueur> getAll() {
		return joueurRepo.findAll();
	}


	public void delete(Joueur joueur) {
		delete(joueur.getId());
	}
	
	public void delete(Long id) {
		Joueur joueur = getById(id);
		Set<Partie> partiesJoueur = joueur.getListeParties();
		partieRepo.deleteByJoueur(joueur);
		/*for (Partie partie : partiesJoueur) {
			partieRepo.delete(partie);
		}
		*/
		joueurRepo.delete(joueur);

	}

	
}
