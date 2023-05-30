package projetArmee.projetArmeeBack.restcontrollers;

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

import projetArmee.projetArmeeBack.entities.Composition;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.CompositionService;

@RestController
@RequestMapping("/api/composition")
public class CompositionRestController {

	@Autowired
	private CompositionService compoSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Composition.class)
	public List<Composition> getAll(){
		return compoSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Composition.class)
	public Composition getById(@PathVariable("id") Long id) {
		return compoSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Composition.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Composition create(@Valid @RequestBody Composition compo,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compoSrv.create(compo);
	}
	

	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Composition.class)
	public Composition update(@Valid @RequestBody Composition compo,BindingResult br,@PathVariable Long id) {
		compo.setId(id);
		return compoSrv.update(compo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compoSrv.delete(id);
	}
}
