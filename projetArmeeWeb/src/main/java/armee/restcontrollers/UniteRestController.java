package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.UniteService;

@RestController
@RequestMapping("/api/unite")
public class UniteRestController {

	@Autowired
	private UniteService uniteSrv;
}
