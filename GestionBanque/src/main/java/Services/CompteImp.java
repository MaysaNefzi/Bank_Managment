package Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.CompteRepository;
import Entities.Compte;
import Metier.CompteMetier;

@Service
public class CompteImp implements CompteMetier {
	@Autowired
	private CompteRepository CR;

	@Override
	public Compte saveCompte(Compte c) {
		c.setCreationDate(new Date());
		return CR.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		return CR.findById(code).get();
	}

}
