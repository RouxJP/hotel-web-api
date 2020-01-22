package dev.hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.entite.ReservationJason;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;

@RestController
public class ReservationController {
	public static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);

	// @Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ChambreRepository chambreRepository;

	public ReservationController(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}



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
		if (clientOpt.isEmpty()) {
			LOG.info("Le client n'existe pas");
			response.sendError(400, "Le client n'existe pas");

		}

		for (String chambre : reservationJason.getChambres()) {
			Optional<Chambre> chambreOpt = chambreRepository.findById(UUID.fromString(chambre));
			if (chambreOpt.isEmpty()) {
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
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	@ResponseBody 
	public List<Reservation> findReservation() {

		return reservationRepository.findAll();

	}
	

}
