package armee.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import armee.entities.Joueur;
import armee.jsonviews.JsonViews;
import armee.services.JoueurService;

@RestController
@RequestMapping("/api/joueur")
public class JoueurRestController {

	@Autowired
	private JoueurService joueurSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Joueur.class)
	public List<Joueur> getAll(){
		return joueurSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Joueur.class)
	public Joueur getById(@PathVariable("id") Long id) {
		return joueurSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Joueur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Joueur create(@Valid @RequestBody Joueur joueur,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return joueurSrv.create(joueur);
	}
	
	@PostMapping("/{login}/{password}")
	@JsonView(JsonViews.Joueur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Joueur create(@PathVariable String login, @PathVariable String password, BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Joueur joueur = new Joueur(login, password);
		return joueurSrv.create(joueur);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Joueur.class)
	public Joueur update(@Valid @RequestBody Joueur joueur,BindingResult br,@PathVariable Long id) {
		joueur.setId(id);
		return joueurSrv.update(joueur);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		joueurSrv.delete(id);
	}
}
