package dev.hotel.entite;

import java.time.LocalDate;
import java.util.List;

public class ReservationJason {
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String clientId;
	List<String> chambres;

	/**
	 * Getter
	 * 
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Setter
	 * 
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Getter
	 * 
	 * @return the chambres
	 */
	public List<String> getChambres() {
		return chambres;
	}

	/**
	 * Setter
	 * 
	 * @param chambres the chambres to set
	 */
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}

}
