package dev.hotel.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@RestController
public class ClientsController {
	public static final Logger LOG = LoggerFactory.getLogger(ClientsController.class);

	// @Autowired
	private ClientRepository clientRepository;

	public ClientsController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findClient(@RequestParam("nom") String nom) {
		LOG.info("nom : " + nom);

		List<Client> lstClients = new ArrayList<Client>();
		for (Client client : clientRepository.findAll()) {
			if (client.getNom().equals(nom)) {
				lstClients.add(client);
			}
		}
		return lstClients;
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@ResponseBody // parser l'objet Client
	public List<Client> findClients() {
		// List<Client> lstClients = new ArrayList<Client>();
		// lstClients = Arrays.asList( new Client ("Pierre", "Jean"), new Client
		// ("Albert", "Dimitri") );
		// return lstClients;

		return clientRepository.findAll();

	}

	@RequestMapping(value = "/insClient1", method = RequestMethod.POST)
	@ResponseBody
	public void insereClient(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
		LOG.info("nom : " + nom);
		LOG.info("prenom : " + prenom);
		Client client = new Client(nom, prenom);

		clientRepository.save(client);

	}

	// Récupérer un objet Client au format JSON par exemple
	@RequestMapping(value = "/insClient2", method = RequestMethod.POST)
	public void create(@RequestBody Client client, HttpServletResponse response) {
		LOG.info("debut");		
		LOG.info("Objet client : " + client.getNom());
		clientRepository.save(client);

	}

}
