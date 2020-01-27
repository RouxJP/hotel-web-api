package dev.hotel.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Reservation;
import dev.hotel.entite.ReservationJason;
import dev.hotel.service.ReservationService;

@RestController
@RequestMapping("reservations")
public class ReservationController {
	public static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);

	private ReservationService reservationService;

	// @Autowired
/**	
	private ReservationRepository reservationRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ChambreRepository chambreRepository;

	public ReservationController(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}
**/
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
/**
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	@ResponseBody 
	public List<Reservation> findReservation() {

		return reservationRepository.findAll();

	}
***/
	@GetMapping
	public List<Reservation> listerResa() {
		return this.reservationService.listerReservations();

	}
	
/**

	@RequestMapping(value = "/insReservation", method = RequestMethod.POST)
	@ResponseBody                           
	public void insertChambre2(@RequestBody ReservationJason reservationJason, HttpServletResponse response)
			throws IOException {            
		List<Chambre> lstChambres = new ArrayList<>();

		LOG.info("Reservation : " + reservationJason.getDateDebut() + " - " + reservationJason.getDateFin());
		LOG.info("Client      : " + reservationJason.getClientId());
		for (String chambre : reservationJason.getChambres()) {
			LOG.info("Chambres      : " + chambre);
		}

		Optional<Client> clientOpt = clientRepository.findById(UUID.fromString(reservationJason.getClientId()));
		if (!clientOpt.isPresent()) {  
			LOG.info("Le client n'existe pas");
			response.sendError(400, "Le client n'existe pas");

		}

		for (String chambre : reservationJason.getChambres()) {
			Optional<Chambre> chambreOpt = chambreRepository.findById(UUID.fromString(chambre));
			if (!chambreOpt.isPresent()) {
				String message = "La chambre " + chambre + " n'existe pas";
				LOG.info(message);
				response.sendError(400, message);

			}
			lstChambres.add(chambreOpt.get());

		}

		Reservation reservation = new Reservation( 
										reservationJason.getDateDebut(), 
										reservationJason.getDateFin(),
										clientOpt.get(), lstChambres);
		
		reservationRepository.save(reservation);

	}
**/
	@PostMapping
	public ResponseEntity<Reservation> postReservation(@RequestBody @Valid ReservationJason reservationRecu) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.reservationService.creerReservation(reservationRecu.getDateDebut(),
				reservationRecu.getDateFin(), reservationRecu.getChambres(), reservationRecu.getClientId()));

	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<String> reservationPresent(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur " + exception.getMessage());
	}
	

}
