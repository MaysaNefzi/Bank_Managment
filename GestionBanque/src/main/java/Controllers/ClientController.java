package Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.ClientRepository;
import Entities.Client;
import Metier.ClientMetier;

@RequestMapping("/client")
public class ClientController implements ClientMetier{
	@Autowired
	private ClientRepository Cl;
	@PostMapping("/newClient")
	public Client saveClient (Client c) {
		return Cl.save(c);
	}
	@GetMapping("/allclients")
	public List<Client> listeClient() {
		return Cl.findAll();
	}
	@PutMapping("/updateClient/{code}")
	public ResponseEntity<Object> updateEmp(@Valid @RequestBody Client c ,@PathVariable("code") long code){
		Optional<Client> ClientOptional = Cl.findById(code);
		if(ClientOptional.isEmpty())
			return ResponseEntity.notFound().build();
		Client C1 = ClientOptional.get();
		C1.setName(c.getName());
		C1.setFirstname(c.getFirstname());
		C1.setEmail(c.getEmail());
		Client result= Cl.save(C1);
		return ResponseEntity.ok().body(result);
		
		
	}
}
