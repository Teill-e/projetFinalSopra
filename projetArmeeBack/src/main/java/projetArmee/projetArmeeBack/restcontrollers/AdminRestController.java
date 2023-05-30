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
import projetArmee.projetArmeeBack.entities.jsonViews.JsonViews;
import projetArmee.projetArmeeBack.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
	private AdminService adminSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Admin.class)
	public List<Admin> getAll(){
		return adminSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Admin.class)
	public Admin getById(@PathVariable("id") Long id) {
		return adminSrv.getById(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Admin.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Admin create(@Valid @RequestBody Admin admin,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminSrv.create(admin);
	}
	
	@PostMapping("/{login}/{password}")
	@JsonView(JsonViews.Admin.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Admin create(@PathVariable String login, @PathVariable String password, BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Admin admin = new Admin(login, password);
		return adminSrv.create(admin);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Admin.class)
	public Admin update(@Valid @RequestBody Admin admin,BindingResult br,@PathVariable Long id) {
		admin.setId(id);
		return adminSrv.update(admin);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminSrv.delete(id);
	}
}
