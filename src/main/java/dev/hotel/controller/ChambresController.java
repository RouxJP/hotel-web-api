package dev.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

@RestController
@RequestMapping("chambres")
public class ChambresController {
	public static final Logger LOG = LoggerFactory.getLogger(ChambresController.class);

	// @Autowired
	private ChambreRepository chambreRepository;

	public ChambresController(ChambreRepository chambreRepository) {
		super();
		this.chambreRepository = chambreRepository;
	}

/**	
	@RequestMapping(value = "/chambres", method = RequestMethod.GET)
	@ResponseBody
	public List<Chambre> findChambre() {
		LOG.info( "Liste de chambres");
		for( Chambre chambre : chambreRepository.findAll()) {
			LOG.info( " - chambres n° : " + chambre.getNumero() + " surface : " + chambre.getSurfaceEnM2());
		}
		return chambreRepository.findAll(); 
	}
**/
	@GetMapping
	public List<Chambre> chambres() {
		return this.chambreRepository.findAll();
	}	
}
