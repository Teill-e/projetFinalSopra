package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.ArmeService;

@RestController
@RequestMapping("/api/arme")
public class ArmeRestController {

	@Autowired
	private ArmeService armeSrv;
}
