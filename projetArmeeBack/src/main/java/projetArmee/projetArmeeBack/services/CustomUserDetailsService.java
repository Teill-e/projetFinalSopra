package projetArmee.projetArmeeBack.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projetArmee.projetArmeeBack.entities.Compte;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CompteService compteSrv;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Compte> compte = compteSrv.findByLogin(username);
		if(compte.isPresent()) 
		{
			return compte.get();
		}
		else {
			throw new UsernameNotFoundException("Identifiants invalides");
		}
	}

}
