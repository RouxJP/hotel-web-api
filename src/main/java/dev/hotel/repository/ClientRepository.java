package dev.hotel.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {
	public Client  findClientByNom(String nom);
	public Client  findClientByPrenoms(String prenoms);
	public Client  findClientByNomAndPrenoms( String nom, String prenoms);
	//public Client  findClientByNomAndPrenoms(String nom, String prenoms);

}
