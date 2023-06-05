package projetArmee.projetArmeeBack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetArmee.projetArmeeBack.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	Optional<Compte> findByLogin(String username);

	boolean existsByLogin(String login);
	
	
	
	

}
