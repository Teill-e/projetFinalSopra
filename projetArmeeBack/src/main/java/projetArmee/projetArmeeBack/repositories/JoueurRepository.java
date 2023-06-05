package projetArmee.projetArmeeBack.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.Partie;


public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
	@Transactional
	@Modifying
	void deleteByListeParties(Partie listeParties);
}
