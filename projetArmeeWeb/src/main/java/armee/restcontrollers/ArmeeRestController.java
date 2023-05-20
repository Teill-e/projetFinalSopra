package armee.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armee.services.ArmeeService;

@RestController
@RequestMapping("/api/armee")
public class ArmeeRestController {

	@Autowired
	private ArmeeService armeeSrv;
}
