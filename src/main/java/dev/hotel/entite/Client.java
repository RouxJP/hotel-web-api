package dev.hotel.entite;


import javax.persistence.Entity;


@Entity
public class Client extends BaseEntite {

	
    private String nom;

    private String prenoms;

    public Client() {
    }

    @Override
    public boolean equals( Client cli) {
    	if( ( this.nom.equals( cli.nom)) && ( this.nom.equals( cli.nom))){
    		return true;
    		
    	}else {
    		return false;
    	}
    }
    
    public Client(String nom, String prenoms) {
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }
}
