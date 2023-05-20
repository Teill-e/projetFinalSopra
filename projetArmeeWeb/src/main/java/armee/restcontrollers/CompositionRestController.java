package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.CompositionService;

@RestController
@RequestMapping("/api/composition")
public class CompositionRestController {

	@Autowired
	private CompositionService compoSrv;
}
