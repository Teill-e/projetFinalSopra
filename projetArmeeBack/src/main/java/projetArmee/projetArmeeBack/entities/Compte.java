package projetArmee.projetArmeeBack.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="compte")
public abstract class Compte implements UserDetails{
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="compte_id")
	private Long id;
	@JsonView(JsonViews.Base.class)
	@Column(name="compte_login",nullable=false, length=20)
	private String login;
	@Column(name="compte_password",nullable=false, length=150)
	private String password;
	
	public Compte() {
	}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> droits = new ArrayList();
		if(this instanceof Admin) 
		{
			droits.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else if(this instanceof Joueur) 
		{
			droits.add(new SimpleGrantedAuthority("ROLE_JOUEUR"));
		}
		return droits;
	}
	
	@JsonView(JsonViews.Base.class)
	public String getRole() 
	{
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
