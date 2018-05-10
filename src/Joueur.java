
public class Joueur {
	String pseudo;
	int forme;
	Boolean tours;
	
	Joueur(String p, int f){
		this.pseudo = p;
		this.forme = f;
		this.tours = false;
	}

	public String getPseudo() {
		return pseudo;
	}


	public int getForme() {
		return forme;
	}

	public Boolean getTours() {
		return tours;
	}

	public void setTours(Boolean tours) {
		this.tours = tours;
	}
	
	@Override
	public String toString() {
		return "pseudo = "+this.pseudo;
	}
}
