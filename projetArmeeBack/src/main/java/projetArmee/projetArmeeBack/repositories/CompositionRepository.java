package projetArmee.projetArmeeBack.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetArmee.projetArmeeBack.entities.Composition;
import projetArmee.projetArmeeBack.entities.Partie;

public interface CompositionRepository extends JpaRepository<Composition, Long> {

	Optional<Composition> findByParties(Partie parties);
	
	@Transactional
	@Modifying
	void deleteByParties(Partie parties);
}
