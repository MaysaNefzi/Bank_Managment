package Metier;

import org.springframework.data.domain.Page;

import Entities.Operation;
import Entities.PageOperation;

public interface OperationMetier {
	public boolean Verser(String code, double montant, Long codeEmpl);
	public boolean Retirer (String code, double montant, Long codeEmpl);
	public boolean Virement( String cpt1, String cpt2, double solde, Long codeEmpl);
	public PageOperation getOperations(String codeC, int page, int size);

}
