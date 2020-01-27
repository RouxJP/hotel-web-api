package dev.hotel.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientsController {
	public static final Logger LOG = LoggerFactory.getLogger(ClientsController.class);

	/**	
	// @Autowired
	private ClientRepository clientRepository;

	public ClientsController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	**/
	private ClientService clientService;

	public ClientsController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}



/**
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@ResponseBody // parser l'objet Client
	public List<Client> findClients() {
		// List<Client> lstClients = new ArrayList<Client>();
		// lstClients = Arrays.asList( new Client ("Pierre", "Jean"), new Client
		// ("Albert", "Dimitri") );
		// return lstClients;

		return clientRepository.findAll();

	}
**/
	@GetMapping(params = "nom")
	public List<Client> rechercherParNom(@RequestParam("nom") String nomRequete) {
		return this.clientService.findByNom(nomRequete);
	}
	
	/**
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
**/	
	@GetMapping
	public List<Client> listerClients() {
		return this.clientService.listerClients();
	}
	
/**	
	
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
	public void create(@RequestBody Client client, HttpServletResponse response) throws IOException {

		LOG.info("Objet client : " + client.getNom());
		LOG.info("Objet client : " + client.getPrenoms());

		Client clientBd = clientRepository.findClientByNomAndPrenoms(client.getNom(), client.getPrenoms());
		if (clientBd != null) {
			LOG.info("Le client existe déja");
			response.sendError(400, "Le client existe déja");

		} else {
			LOG.info("Le client n'existe déja on le crée");
			clientRepository.save(client);
		}

	}
**/	
	@PostMapping
	public UUID creerClient(@RequestBody @Valid Client clientRecu) {
		return this.clientService.creerClient(clientRecu);
	}

	
}
