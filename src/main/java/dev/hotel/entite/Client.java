package dev.hotel.entite;


import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name = "client")
public class Client extends BaseEntite {

	
	@NotEmpty
	@Size(min = 3, max = 50)
    private String nom;

	@NotEmpty
	@Size(min = 4)
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
