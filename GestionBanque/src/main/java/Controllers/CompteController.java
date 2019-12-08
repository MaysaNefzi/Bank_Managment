package Controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.CompteRepository;
import Entities.Compte;
import Metier.CompteMetier;

@RequestMapping("/compte")
public class CompteController implements CompteMetier {
	@Autowired
	private CompteRepository CR;

	@PostMapping("/newCompte")
	public Compte saveCompte(Compte c) {
		c.setCreationDate(new Date());
		return CR.save(c);
	}

	@GetMapping("/allcomptes")
	public Compte getCompte(String code) {
		return CR.findById(code).get();
	}
	@GetMapping("/compteById/{code}")
	public Optional<Compte> findCptById(@PathVariable("code") String codeCpt) {
		return CR.findById(codeCpt);
    }
	@DeleteMapping("/removeCompte/{code}")
    public ResponseEntity<?> deleteCpt(@PathVariable("id") String codecpt) {
        CR.deleteById(codecpt);
        return ResponseEntity.ok().build();
    }
}