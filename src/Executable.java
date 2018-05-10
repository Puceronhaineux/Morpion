
public class Executable {

	public static void main(String[] args) {
//		Matrice m = new Matrice(3,3,0);
//		System.out.println(m);
//		Plateau j = new Plateau("joueur1", "joueur2");
//		System.out.println(j.getJoueurEnJeu());
//		j.setTours();
//		System.out.println(j.getJoueurEnJeu());
//		j.setTours();
//		System.out.println(j.getJoueurEnJeu());
//		j.setTours();
//		System.out.println(j.getJoueurEnJeu());
//		j.placerJeton(0, 0);
//		System.out.println(j.getMat());
		System.out.println("----------------------------TEST JEU-----------------");
		Morpion j = new Morpion("joueur1", "joueur2");
		j.jouer();
	}

}
