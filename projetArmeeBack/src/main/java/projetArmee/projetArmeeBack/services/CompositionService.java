package projetArmee.projetArmeeBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetArmee.projetArmeeBack.entities.Composition;
import projetArmee.projetArmeeBack.entities.Partie;
import projetArmee.projetArmeeBack.exceptions.CompositionException;
import projetArmee.projetArmeeBack.repositories.CompositionRepository;
import projetArmee.projetArmeeBack.repositories.UniteRepository;

@Service
public class CompositionService {
	@Autowired
	private CompositionRepository compositionRepo;
	
	@Autowired
	private UniteRepository uniteRepo;
	
	
	private void checkComposition(Composition composition) {
		if (composition == null) {
			throw new CompositionException("composition null");
		}
		if (composition.getUnites() == null || composition.getParties() == null) {
			throw new CompositionException("informations manquantes");
		}
	}
	
	private void checkId(Long id) {
		if(id == null) {
			throw new CompositionException("id null");
		}
	}
	
	public Composition getById(Long id) {
		checkId(id);
		return compositionRepo.findById(id).orElseThrow(() -> {
			throw new CompositionException("id inconnu");
		});		
	}
	
	public Composition create(Composition composition) {
		checkComposition(composition);
		return compositionRepo.save(composition);
	}
	
	public Composition update(Composition composition) {
		Composition compositionEnBase = getById(composition.getId());
		checkComposition(composition);
		compositionEnBase.setUnites(composition.getUnites());
		compositionEnBase.setParties(composition.getParties());
		return compositionRepo.save(compositionEnBase);
	}
	
	public List<Composition> getAll(){
		return compositionRepo.findAll();
	}
	
	public Composition findByParties(Partie parties){
		return compositionRepo.findByParties(parties).orElseThrow(() -> {
			throw new CompositionException("Pas de composition pour ces parties");
		});
	}
	
	public void delete(Composition composition) {
		delete(composition.getId());
	}
	
	public void delete(Long id) {
		Composition CompositionEnBase = getById(id);
		uniteRepo.deleteByComposition(CompositionEnBase);
		compositionRepo.delete(CompositionEnBase);
	}
}
