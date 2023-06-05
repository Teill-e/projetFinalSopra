package projetArmee.projetArmeeBack.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;

@Entity
@Table(name = "partie")
public class Partie {
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partie_id")
	private Long id;
	@JsonView(JsonViews.Base.class)
	@Column(name = "partie_date")
	private LocalDate date;
	@JsonView(JsonViews.Base.class)
	@Column(name = "partie_fin")
	private boolean fin;
	@JsonView(JsonViews.Joueur.class)
	@ManyToOne
	@JoinColumn(name = "partie_joueur")
	private Joueur joueur;
	@ManyToOne
	@JoinColumn(name = "partie_compo_joueur")
	private Composition compoJoueur;
	@ManyToOne
	@JoinColumn(name = "partie_compo_ia")
	private Composition compoIA;
	

	public Partie() {
	}

	

	public Partie(LocalDate date, boolean fin) {
		super();
		this.date = date;
		this.fin = fin;
	}



	public Partie(LocalDate date, boolean fin, Joueur joueur) {
		super();
		this.date = date;
		this.fin = fin;
		this.joueur = joueur;
	}



	public Partie(LocalDate date, boolean fin, Joueur joueur, Composition compoJoueur, Composition compoIA) {
		this.date = date;
		this.fin = fin;
		this.joueur = joueur;
		this.compoJoueur = compoJoueur;
		this.compoIA = compoIA;
	}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Joueur getJoueur() {
		return joueur;
	}



	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}



	public Composition getCompoJoueur() {
		return compoJoueur;
	}



	public void setCompoJoueur(Composition compoJoueur) {
		this.compoJoueur = compoJoueur;
	}



	public Composition getCompoIA() {
		return compoIA;
	}



	public void setCompoIA(Composition compoIA) {
		this.compoIA = compoIA;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		return Objects.equals(id, other.id);
	}

}
