import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VueMorpion extends Application{
	private Morpion jeu;
	private String n1;
	private String n2;
	private GridPane plat;
	private BorderPane bp;
	private List<Button> lsB;
	Label toursA;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Scene scene() {
		//PAN
		bp = new BorderPane();
		
		bp.setCenter(this.getPlateau());
		VBox pan = new VBox();
		pan.getChildren().add(toursA);
		pan.setAlignment(Pos.CENTER);
		bp.setTop(pan);
		
		return new Scene(bp,200,200);
		
	}
	
	public GridPane getPlateau() {
		plat = new GridPane();
		lsB = new ArrayList<Button>();
		ActionBoutton act = new ActionBoutton(this);
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				Button b = new Button(" ");
				if(this.jeu.p.getVal(j, i) == 1) {
					b = new Button("X");
				}
				if(this.jeu.p.getVal(j, i) == 2) {
					b = new Button("O");
				}
				if(this.jeu.p.getVal(j, i) == 0) {
					 b = new Button(" ");
				}
				b.setFocusTraversable(false);
				b.setPrefSize(50, 50);
				b.setUserData(i+""+j);
				b.setOnAction(act);
				lsB.add(b);
				plat.add(b,i, j);				
			}
		}
		plat.setAlignment(Pos.CENTER);
		plat.setVgap(5);
		plat.setHgap(5);
		return plat;
	}
	
	public void maj() {
		plat = new GridPane();
		lsB = new ArrayList<Button>();
		ActionBoutton act = new ActionBoutton(this);
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				Button b = new Button(" ");
				if(this.jeu.p.getVal(j, i) == 1) {
					b = new Button("X");
				}
				if(this.jeu.p.getVal(j, i) == 2) {
					b = new Button("O");
				}
				if(this.jeu.p.getVal(j, i) == 0) {
					 b = new Button(" ");
				}
				b.setFocusTraversable(false);
				b.setUserData(i+""+j);
				b.setOnAction(act);
				b.setPrefSize(50, 50);
				lsB.add(b);
				plat.add(b,i, j);				
			}
		}
		plat.setAlignment(Pos.CENTER);
		plat.setVgap(5);
		plat.setHgap(5);
		
		VBox pan = new VBox();
		this.toursA = new Label("C'est au tours de : "+this.getJeu().getJoueurEnJeu().pseudo);
		this.toursA.setFont(Font.font("Verdana", FontWeight.BOLD,12));
		pan.getChildren().add(toursA);
		pan.setAlignment(Pos.CENTER);
		
		bp.setCenter(plat);
		bp.setTop(pan);
	}
	
	@Override
	public void start(Stage s) throws Exception {
		this.setNomJoueur();
		this.jeu = new Morpion(n1,n2);
		this.toursA = new Label("C'est au tours de : "+this.getJeu().getJoueurEnJeu().pseudo);
		this.toursA.setFont(Font.font("Verdana", FontWeight.BOLD,12));
		s.setTitle("Morpion");
		s.setScene(scene());
		s.setResizable(false);
		s.show();
	}
	
	private void setNomJoueur() {
		TextInputDialog dialog = new TextInputDialog("Joueur1");
		dialog.setTitle("Formulaire");
		dialog.setHeaderText("Joueur 1");
		dialog.setContentText("Entrez votre nom :");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			this.n1 = result.get();
		}
		else {
			this.n1 = "Joueur1";
		}

		TextInputDialog dialog2 = new TextInputDialog("Joueur2");
		dialog2.setTitle("Formulaire");
		dialog2.setHeaderText("Joueur 2");
		dialog2.setContentText("Entrez votre nom :");
		Optional<String> result2 = dialog2.showAndWait();
		if (result2.isPresent()){
			this.n2 = result2.get();
		}
		else {
			this.n2 = "Joueur2";
		}
	}

	public Morpion getJeu() {
		return jeu;
	}

	public String getN1() {
		return n1;
	}

	public String getN2() {
		return n2;
	}

	public GridPane getPlat() {
		return plat;
	}

	public BorderPane getBp() {
		return bp;
	}

	public List<Button> getLsB() {
		return lsB;
	}

	public Label getToursA() {
		return toursA;
	}
	
	
	
	
}
