package Services;

import java.awt.print.Pageable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.CompteRepository;
import DAO.EmployeeRepository;
import DAO.OperationRepository;
import Entities.Compte;
import Entities.Employee;
import Entities.Operation;
import Entities.PageOperation;
import Entities.Retrait;
import Entities.Versement;
import Metier.OperationMetier;

@Service
public class OperationImp  implements OperationMetier{
	@Autowired
	private OperationRepository OPR;
	@Autowired
	private CompteRepository CR;
	@Autowired
	private EmployeeRepository ER;

	@Transactional
	public boolean Verser(String code, double montant, Long codeEmpl) {
		Compte cp=CR.findById(code).get();
		Employee Empl=ER.findById(codeEmpl).get();
		Operation o= new Versement();
		o.setEmploye(Empl);
		o.setCompte(cp);
		o.setMontant(montant);
		o.setDateOperation(new Date());
		OPR.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Transactional
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
	public boolean Virement(String cpt1, String cpt2, double montant, Long codeEmpl) {
		if(cpt1 == cpt2)throw new RuntimeException("Impossible : On ne peut pas effectuer un virement dans le meme compte");
		Retirer(cpt1, montant, codeEmpl);
		Verser(cpt2, montant, codeEmpl);
		return true;
	}

	@Override
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


	/*@Override
	public Page<Operation> ListOperations(String codeC, int page, int size) {
		return OPR.listOperation(codeC,(Pageable) new  PageRequest(page,size, null));
	}*/
	


}
