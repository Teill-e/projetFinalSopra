package projetArmee.projetArmeeBack.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import projetArmee.projetArmeeBack.entities.Armee;




public interface ArmeeRepository extends JpaRepository<Armee, Long> {

	
	
}