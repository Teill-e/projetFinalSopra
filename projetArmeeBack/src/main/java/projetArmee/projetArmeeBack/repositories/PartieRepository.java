package projetArmee.projetArmeeBack.repositories;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetArmee.projetArmeeBack.entities.Composition;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {
	Optional<Partie> findByDate(LocalDate date);
	
	Optional<Partie> findByJoueur(Joueur joueur);
	
	
	
	@Transactional
	@Modifying
	void deleteByJoueur(Joueur joueur);
	
	@Transactional
	@Modifying
	void deleteByCompoJoueur(Composition compoJoueur);
	
}
