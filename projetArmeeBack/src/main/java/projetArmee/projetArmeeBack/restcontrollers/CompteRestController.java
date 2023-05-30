package projetArmee.projetArmeeBack.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import projetArmee.projetArmeeBack.entities.Admin;
import projetArmee.projetArmeeBack.entities.Compte;
import projetArmee.projetArmeeBack.entities.Joueur;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "http://localhost:4200")
public class CompteRestController {

	@Autowired
	private CompteService compteSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Compte.class)
	public List<Compte> getAll(){
		return compteSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Compte getById(@PathVariable("id") Long id) {
		return compteSrv.getById(id);
	}
	
	@PostMapping("/admin")
	@JsonView(JsonViews.Compte.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte createAdmin(@Valid @RequestBody Admin compte,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteSrv.create(compte);
	}
	@PostMapping("")
	@JsonView(JsonViews.Compte.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte create(@Valid @RequestBody Joueur compte,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteSrv.create(compte);
	}
	
	
	/*@PostMapping("/{login}/{password}")
	@JsonView(JsonViews.Compte.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte create(@PathVariable String login, @PathVariable String password, BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Compte compte = new Joueur(login, password);
		return compteSrv.create(compte);
	}
	*/
	@PutMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Compte update(@Valid @RequestBody Compte compte,BindingResult br,@PathVariable Long id) {
		compte.setId(id);
		return compteSrv.update(compte);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compteSrv.delete(id);
	}
}
