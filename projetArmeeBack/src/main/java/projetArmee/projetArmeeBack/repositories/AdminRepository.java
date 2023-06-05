package projetArmee.projetArmeeBack.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetArmee.projetArmeeBack.entities.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long> {

}
