package projetArmee.projetArmeeBack.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Entity
public class Joueur extends Compte{
	@ManyToMany
	@JoinColumn(name = "partie_id")
	private Set<Partie> listeParties;
	
	public Joueur() {
	}
 
	

	public Joueur(String login, String password, Set<Partie> listeParties) {
		super(login,password);
		this.listeParties = listeParties;
	}

	public Joueur(String login, String password) {
		super(login,password);	
	}


	public Set<Partie> getListeParties() {
		return listeParties;
	}



	public void setListeParties(Set<Partie> listeParties) {
		this.listeParties = listeParties;
	}

	
} 
