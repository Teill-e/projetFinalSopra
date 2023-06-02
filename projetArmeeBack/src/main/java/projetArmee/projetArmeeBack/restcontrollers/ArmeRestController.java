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

import projetArmee.projetArmeeBack.entities.Arme;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.ArmeService;

@RestController
@RequestMapping("/api/arme")
@CrossOrigin(origins = "http://localhost:4200")
public class ArmeRestController {

	@Autowired
	private ArmeService armeSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Arme.class)
	public List<Arme> getAll(){
		return armeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Arme.class)
	public Arme getById(@PathVariable("id") Long id) {
		return armeSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Arme.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Arme create(@Valid @RequestBody Arme arme,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return armeSrv.create(arme);
	}
	
	
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Arme.class)
	public Arme update(@Valid @RequestBody Arme arme,BindingResult br,@PathVariable Long id) {
		arme.setId(id);
		return armeSrv.update(arme);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		armeSrv.delete(id);
	}
}
