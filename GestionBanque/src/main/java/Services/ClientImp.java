package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.ClientRepository;
import Entities.Client;
import Metier.ClientMetier;

@Service
public class ClientImp implements ClientMetier{
	@Autowired
	private ClientRepository Cl;
	public Client saveClient (Client c) {
		return Cl.save(c);
	}
	@Override
	public List<Client> listeClient() {
		return Cl.findAll();
	}
	

}
