package projetArmee.projetArmeeBack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class JoueurException extends RuntimeException {
	
	public JoueurException() {

	}

	public JoueurException(String message) {
		super(message);
	}

}
