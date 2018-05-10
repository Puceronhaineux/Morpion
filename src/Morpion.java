import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Morpion {
	Matrice p;
	List<Joueur> lsP;
	String gagnant = "aucun";
	
	Morpion(String n1, String n2){
		this.lsP = new ArrayList<Joueur>();
		p = new Matrice(3,3,0);
		Joueur j1 = new Joueur(n1,1);
		Joueur j2 = new Joueur(n2,2);
		j1.setTours(true);
		this.lsP.add(j1);
		this.lsP.add(j2);
	}
	
	public void setTours() {
		if(this.lsP.get(0).getTours()) {
			this.lsP.get(0).setTours(false);
			this.lsP.get(1).setTours(true);
		}
		else if(this.lsP.get(1).getTours()) {
			this.lsP.get(0).setTours(true);
			this.lsP.get(1).setTours(false);
		}
	}
	
	public Joueur getJoueurEnJeu() {
		Joueur res = null;
		for(Joueur j : this.lsP) {
			if(j.getTours()) {
				res = j;
			}
		}
		return res;
	}
	
	public void placerJeton() {
		boolean continuer = true;
		while(continuer) {
			System.out.println("Ligne :\n>");
			Scanner x = new Scanner(System.in);
			int getx = x.nextInt();
			System.out.println("Colonne :\n>");
			Scanner y = new Scanner(System.in);
			int gety = y.nextInt();
			if(this.p.getVal(getx, gety)!=0) {
				System.out.println("erreur !");
			}
			else {
				this.p.setVal(getx, gety, this.getJoueurEnJeu().getForme());
				continuer = false;
			}
		}
		
		
	}
	
	public void placerJeton(int x, int y) {
		this.p.setVal(x, y, this.getJoueurEnJeu().getForme());
	}
	
	public boolean matcheNull() {
		if(!this.p.getListeDesValeurs().contains(0) && !this.checkFinPartie()) {
			return true;
		}
		return false;
	}
	
	public Matrice getMat() {
		return this.p;
	}
	
	public boolean checkFinPartie() {
		int cpt=0;
		for(int i = 0; i<this.p.getNbLignes(); i++) {
			for(int j = 1; j<this.p.getLigne(i).size(); j++) {
				if(this.p.getLigne(i).get(j)==this.p.getLigne(i).get(j-1) && this.p.getLigne(i).get(j)!=0) {
					cpt+=1;
				}
				else {
					cpt=0;
				}
				
				if(cpt==2) {
					return true;
				}
			}
		}
		
		cpt=0;
		for(int i = 0; i<this.p.getNbColonnes(); i++) {
			for(int j = 1; j<this.p.getColonne(i).size(); j++) {
				if(this.p.getColonne(i).get(j)==this.p.getColonne(i).get(j-1) && this.p.getColonne(i).get(j)!=0) {
					cpt+=1;
				}
				else {
					cpt=0;
				}

				if(cpt==2) {
					return true;
				}
			}
		}
		
		cpt=0;
		for(int i = 1; i<this.p.getDiagonalDroite(2).size(); i++) {
			if(this.p.getDiagonalDroite(2).get(i)==this.p.getDiagonalDroite(2).get(i-1) && this.p.getDiagonalDroite(2).get(i)!=0) {
				cpt+=1;
			}

			if(cpt==2) {
				return true;
			}
		}
		
		
		cpt=0;
		for(int i = 1; i<this.p.getDiagonalGauche(0).size(); i++) {
			if(this.p.getDiagonalGauche(0).get(i)==this.p.getDiagonalGauche(0).get(i-1) && this.p.getDiagonalGauche(0).get(i)!=0) {
				cpt+=1;
			}

			if(cpt==2) {
				return true;
			}
		}
		return false;
	}
	
	public void jouer() {
		boolean continuer = true;
		while(continuer) {
			System.out.println(this.getJoueurEnJeu());
			this.placerJeton();
			System.out.println(this.getMat());
			if(this.checkFinPartie()) {
				System.out.println(this.getJoueurEnJeu()+" a gagné !");
				continuer = false;
			}
			this.setTours();
		}
	}
	
	public void jouer(int x, int y) {
		if(this.p.getVal(x, y)==0) {
			this.placerJeton(x,y);
			if(this.checkFinPartie()) {
				gagnant = this.getJoueurEnJeu().getPseudo();
			}
			else {
				this.setTours();
			}
		}
		
	}
	
	public String getGagnant() {
		return this.gagnant;
	}
}
