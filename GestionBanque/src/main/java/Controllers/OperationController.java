package Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.CompteRepository;
import DAO.EmployeeRepository;
import DAO.OperationRepository;
import Entities.Compte;
import Entities.Employee;
import Entities.Operation;
import Entities.Retrait;
import Entities.Versement;
import Metier.OperationMetier;

@RequestMapping("/Operation")
public class OperationController  implements OperationMetier{
	@Autowired
	private OperationRepository OPR;
	@Autowired
	private CompteRepository CR;
	@Autowired
	private EmployeeRepository ER;

	@Transactional
	@PostMapping("/versement")
	public boolean Verser(String code, double montant, Long codeEmpl) {
		Compte cp=CR.findById(code).get();
		Employee Empl=ER.findById(codeEmpl).get();
		Operation o= new Versement();
		o.setEmploye(Empl);
		o.setCompte(cp);
		o.setMontant(montant);
		o.setDateOperation(new Date());
		OPR.save(o);
		cp.setSolde(cp.getSolde()+montant) ;
		CR.save(cp); 
		return true;
	}

	@Transactional
	@PostMapping("/retrait")
	public boolean Retirer(String code, double montant, Long codeEmpl) {
		Compte cp=CR.findById(code).get();
		if (cp.getSolde()<montant ) throw new RuntimeException
		("Solde insuffisant");
		Employee Empl=ER.findById(codeEmpl).get();
		Operation o= new Retrait();
		o.setEmploye(Empl);
		o.setCompte(cp);
		o.setMontant(montant);
		o.setDateOperation(new Date());
		OPR.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Transactional
	@PostMapping("/virement")
	public boolean Virement(String cpt1, String cpt2, double montant, Long codeEmpl) {
		if(cpt1 == cpt2)throw new RuntimeException("Impossible : On ne peut pas effectuer un virement dans le meme compte");
		Retirer(cpt1, montant, codeEmpl);
		Verser(cpt2, montant, codeEmpl);
		return true;
	}
	/*@GetMapping("/listOperation")
	public PageOperation getOperations(String codeC, int page, int size) {
		Page<Operation> ops=OPR.listOperation(codeC, new PageRequest(page, size,Sort.unsorted()));
		PageOperation pop= new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalpages(ops.getTotalPages());
		pop.setTotalOperations((int) ops.getTotalElements());
		return pop;
	}


	@Override
	public Page<Operation> ListOperations(String codeC, int page, int size) {
		// TODO Auto-generated method stub
		return OPR.listOperation(codeC, new PageRequest(page,size));
	}*/

}
