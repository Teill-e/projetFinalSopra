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

import projetArmee.projetArmeeBack.entities.Partie;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.PartieService;

@RestController
@RequestMapping("/api/partie")
@CrossOrigin(origins = "http://localhost:4200")
public class PartieRestController {

	@Autowired
	private PartieService partieSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Partie.class)
	public List<Partie> getAll(){
		return partieSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Partie.class)
	public Partie getById(@PathVariable("id") Long id) {
		return partieSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Partie.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Partie create(@Valid @RequestBody Partie partie,BindingResult br) {
		System.out.println(partie.toString());
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return partieSrv.create(partie);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Partie.class)
	public Partie update(@Valid @RequestBody Partie partie,BindingResult br,@PathVariable Long id) {
		partie.setId(id);
		return partieSrv.update(partie);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		partieSrv.delete(id);
	}
}
