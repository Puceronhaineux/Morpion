import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet le placement et la creation du plateau du jeu Puissance 4
 * @author erwan
 *
 */

public class Matrice{
	private int nbLignes;
	private int nbColonnes;
	private List<Integer> listeDesValeurs;
	private int valeurParDef;

	/**
	 * Le constructeur prend en parametre le nombre de ligne, le nombre de colonne et la valeur par defaut
	 * @param nbLignes
	 * @param nbColonnes
	 * @param valeurParDef
	 */

	public Matrice(int nbLignes, int nbColonnes, int valeurParDef) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.valeurParDef = valeurParDef;
		this.listeDesValeurs = new ArrayList<Integer>();
		for(int i = 0; i<(nbLignes*nbColonnes); i++) {
			this.listeDesValeurs.add(valeurParDef);
		}




	}

	/**
	 * Cette fonction previent si la matrice est remplit ou non
	 * @return
	 */

	public boolean matriceFull() {
		return !this.listeDesValeurs.contains(this.valeurParDef); //Si la liste ne contient plus aucune valeur par defaut
	}

	/**
	 * Cette fonction donne le nombre de ligne de la matrice
	 * @return
	 */

	public int getNbLignes() {
		return this.nbLignes;
	}

	/**
	 * Cette fonction donne le nombre de colonne de la matrice
	 * @return
	 */

	public int getNbColonnes() {
		return this.nbColonnes;
	}

	/**
	 * Cette fonction donne la valeur x,y de la matrice
	 * @param lig
	 * @param col
	 * @return
	 */

	public int getVal(int lig, int col) {
		return this.listeDesValeurs.get((lig*this.nbColonnes)+col);
	}

	/**
	 * Cette fonction insere une valeur aux coordonnées x,y de la matrice
	 * @param lig
	 * @param col
	 * @param val
	 */

	public void setVal(int lig, int col, int val) {
		this.listeDesValeurs.set((lig*this.nbColonnes)+col, val);
	}

	/**
	 * Cette fonction ressort la liste de valeur d'une certaine colonne
	 * @param i
	 * @return
	 */

	public List<Integer> getColonne(int i){
		List<Integer> res = new ArrayList<Integer>();
		for(int l = 0; l<this.getNbLignes(); l++) {
			res.add(this.getVal(l, i));
		}
		return res;
	}

	/**
	 * Cette fonction ressort la liste de valeur d'une certaine ligne
	 * @param i
	 * @return
	 */

	public List<Integer> getLigne(int i){
		List<Integer> res = new ArrayList<Integer>();
		for(int c = 0; c<this.getNbColonnes(); c++) {
			res.add(this.getVal(i, c));
		}
		return res;
	}

	/**
	 * Cette fonction ressort la liste de valeur d'une certaine diagonal gauche
	 * @param c
	 * @return
	 */

	public List<Integer> getDiagonalGauche(int c){
		int val;
		List<Integer> res = new ArrayList<Integer>();
		if(c<2) { 
			val = this.getNbLignes();
		}
		else { 
			val = (this.getNbLignes()-c)+1;
		}
		for(int i = 0; i < val; i++){
			res.add(this.getVal(i, c+i));
		}
		return res;
	}

	/**
	 * Cette fonction ressort la liste de valeur d'une certaine diagonal droite
	 * @param c
	 * @return
	 */

	public List<Integer> getDiagonalDroite(int c){
		int val;
		List<Integer> res = new ArrayList<Integer>();
		if(c>this.getNbColonnes()-2) { 
			val = this.getNbLignes();
		}
		else { 
			val = (c-(this.getNbLignes()-this.getNbLignes()))+1;
		}
		for(int i = 0; i < val; i++){
			res.add(this.getVal(i, c-i));
		}
		return res;
	}

	
	
	public List<Integer> getListeDesValeurs() {
		return listeDesValeurs;
	}

	@Override
	public String toString() {
		int nbColonnes = this.nbColonnes;
		int nbLignes = this.nbLignes;
		String res = "";
		for(int i = 0; i<nbLignes; i++) {
			for(int j = 0; j<nbColonnes; j++) {
				res+=this.getVal(i,j)+" ";
			}
			res+="\n";
		}
		return res;
	}
}
