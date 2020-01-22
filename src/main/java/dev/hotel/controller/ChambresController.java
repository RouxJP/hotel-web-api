package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

@RestController
public class ChambresController {
	public static final Logger LOG = LoggerFactory.getLogger(ChambresController.class);

	// @Autowired
	private ChambreRepository chambreRepository;

	public ChambresController(ChambreRepository chambreRepository) {
		super();
		this.chambreRepository = chambreRepository;
	}

	@RequestMapping(value = "/chambres", method = RequestMethod.GET)
	@ResponseBody
	public List<Chambre> findChambre() {
		List<Chambre> lstChambres = new ArrayList<Chambre>();
		return chambreRepository.findAll();
	}

}
