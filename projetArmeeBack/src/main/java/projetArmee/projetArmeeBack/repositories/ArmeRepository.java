package projetArmee.projetArmeeBack.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetArmee.projetArmeeBack.entities.Arme;
import projetArmee.projetArmeeBack.entities.Unite;

public interface ArmeRepository extends JpaRepository<Arme, Long> {
	Optional<Arme> findByUniteArmes (Unite unite);

	
	@Transactional
	@Modifying
	void deleteByUniteArmes(Unite uniteArmes);
}
