package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.PartieService;

@RestController
@RequestMapping("/api/partie")
public class PartieRestController {

	@Autowired
	private PartieService partieSrv;
}
