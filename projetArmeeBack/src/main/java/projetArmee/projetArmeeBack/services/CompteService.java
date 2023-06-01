package projetArmee.projetArmeeBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projetArmee.projetArmeeBack.entities.Admin;
import projetArmee.projetArmeeBack.entities.Compte;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.Role;
import projetArmee.projetArmeeBack.exceptions.CompteException;
import projetArmee.projetArmeeBack.repositories.AdminRepository;
import projetArmee.projetArmeeBack.repositories.CompteRepository;
import projetArmee.projetArmeeBack.repositories.JoueurRepository;
import projetArmee.projetArmeeBack.repositories.PartieRepository;

@Service
public class CompteService {
	@Autowired
	private CompteRepository compteRepo;

	@Autowired
	private JoueurRepository joueurRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private PartieRepository partieRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public boolean loginExist(String login) {
		return compteRepo.existsByLogin(login);
	}

	private void checkCompte(Compte compte) {
		if (compte == null) {
			throw new CompteException("compte null");
		}
		if (compte.getLogin() == null || compte.getPassword() == null) {
			throw new CompteException("informations manquantes");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new CompteException("id null");
		}
	}

	public Compte getById(Long id) {
		checkId(id);
		return compteRepo.findById(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});
	}

	public Compte create(Compte compte) {
		checkCompte(compte);
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		//if (!loginExist(compte.getLogin())) {
			return compteRepo.save(compte);
		//}
		//throw new CompteException();
	}

//	public Compte createAdmin(String login, String password) {
//		return create(new Compte(login, password, Role.ROLE_ADMIN));
//	}
//
//	public Compte createJoueur(String login, String password) {
//		return create(new Compte(login, password, Role.ROLE_JOUEUR));
//	}

	public Compte update(Compte compte) {
		Compte compteEnBase = getById(compte.getId());
		checkCompte(compte);
		compteEnBase.setLogin(compte.getLogin());
		compteEnBase.setPassword(compte.getPassword());
		return compteRepo.save(compteEnBase);
	}

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	public void delete(Compte compte) {
		delete(compte.getId());
	}

	public void delete(Long id) {
		Compte CompteEnBase = getById(id);
		if (CompteEnBase instanceof Admin) {
			deleteAdmin(CompteEnBase);
		}

		if (CompteEnBase instanceof Joueur) {
			deleteJoueur(CompteEnBase);
		}
	}

	public void deleteJoueur(Compte joueur) {
		partieRepo.deleteByJoueur((Joueur) joueur);
		joueurRepo.delete((Joueur) joueur);

	}

	public void deleteAdmin(Compte admin) {

		adminRepo.delete((Admin) admin);

	}

	public Optional<Compte> findByLogin(String username) {
		return compteRepo.findByLogin(username);

	}

}
