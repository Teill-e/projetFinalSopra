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

import armee.entities.Armee;
import armee.jsonviews.JsonViews;
import armee.services.ArmeeService;

@RestController
@RequestMapping("/api/armee")
public class ArmeeRestController {

	@Autowired
	private ArmeeService armeeSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Armee.class)
	public List<Armee> getAll(){
		return armeeSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Armee.class)
	public Armee getById(@PathVariable("id") Long id) {
		return armeeSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Armee.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Armee create(@Valid @RequestBody Armee armee,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return armeeSrv.create(armee);
	}
	
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Armee.class)
	public Armee update(@Valid @RequestBody Armee armee,BindingResult br,@PathVariable Long id) {
		armee.setId(id);
		return armeeSrv.update(armee);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		armeeSrv.delete(id);
	}
}
