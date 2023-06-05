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

import projetArmee.projetArmeeBack.entities.Unite;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.UniteService;

@RestController
@RequestMapping("/api/unite")
@CrossOrigin(origins = "http://localhost:4200")
public class UniteRestController {

	@Autowired
	private UniteService uniteSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Unite.class)
	public List<Unite> getAll(){
		return uniteSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Unite.class)
	public Unite getById(@PathVariable("id") Long id) {
		return uniteSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Unite.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Unite create(@Valid @RequestBody Unite unite,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return uniteSrv.create(unite);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Unite.class)
	public Unite update(@Valid @RequestBody Unite unite,BindingResult br,@PathVariable Long id) {
		unite.setId(id);
		return uniteSrv.update(unite);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		uniteSrv.delete(id);
	}
}
