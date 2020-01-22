package dev.hotel.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation extends BaseEntite {

	private LocalDate dateDebut;
	private LocalDate dateFin;

	@ManyToOne
	@JoinColumn(name = "res_client")
	private Client client;

	@ManyToMany
	@JoinTable(name = "reservation_chambre", joinColumns = @JoinColumn(name = "res_id", referencedColumnName = "uuid"), inverseJoinColumns = @JoinColumn(name = "cli_id", referencedColumnName = "uuid"))
	private List<Chambre> chambres = new ArrayList<>();

	public Reservation() {
	}

	public Reservation(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.chambres = chambres;
	}

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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter
	 * 
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter
	 * 
	 * @return the chambres
	 */
	public List<Chambre> getChambres() {
		return chambres;
	}

	/**
	 * Setter
	 * 
	 * @param chambres the chambres to set
	 */
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	// @OneToMany(mappedBy = "chambres")
	// private List<String> chambres = new ArrayList<>();

}
