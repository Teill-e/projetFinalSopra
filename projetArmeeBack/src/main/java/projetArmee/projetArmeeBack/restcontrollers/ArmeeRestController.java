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

import projetArmee.projetArmeeBack.entities.Armee;
import projetArmee.projetArmeeBack.entities.ArmeeAir;
import projetArmee.projetArmeeBack.entities.ArmeeTerre;
import projetArmee.projetArmeeBack.entities.Marine;
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.ArmeeService;

@RestController
@RequestMapping("/api/armee")
@CrossOrigin(origins = "http://localhost:4200")
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
	
	/*@PostMapping("/{type}")
	@JsonView(JsonViews.Armee.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Armee create(@Valid @RequestBody Armee armee,BindingResult br,@PathVariable String type) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		if(type.equals("terre")) 
		{
			return armeeSrv.create((ArmeeTerre)armee);
		}
		else if(type.equals("mer")) 
		{
			return armeeSrv.create((Marine)armee);
		}
		else if(type.equals("air")) 
		{
			return armeeSrv.create((ArmeeAir)armee);
		}
		else 
		{
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}*/
	
	
	@PostMapping("/terre")
	@JsonView(JsonViews.Armee.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Armee create(@Valid @RequestBody ArmeeTerre armee,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return armeeSrv.create(armee);
	}
	
	@PostMapping("/air")
	@JsonView(JsonViews.Armee.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Armee create(@Valid @RequestBody ArmeeAir armee,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return armeeSrv.create(armee);
	}
	@PostMapping("/marine")
	@JsonView(JsonViews.Armee.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Armee create(@Valid @RequestBody Marine armee,BindingResult br) {
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
