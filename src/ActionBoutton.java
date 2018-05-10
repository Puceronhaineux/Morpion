import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ActionBoutton implements EventHandler<ActionEvent> {
	VueMorpion app;
	
	ActionBoutton(VueMorpion app){
		this.app = app;
	}
	
	@Override
	public void handle(ActionEvent a) {
		Button b = (Button) a.getSource();
		String[] val = b.getUserData().toString().split("");
		this.app.getJeu().jouer(Integer.parseInt(val[1]), Integer.parseInt(val[0]));
		this.app.maj();
		if(this.app.getJeu().checkFinPartie()) {
			for(Button button : this.app.getLsB()) {
				button.setDisable(true);
			}
			this.app.getToursA().setText("");
			Alert bravo = new Alert(AlertType.INFORMATION);
			bravo.setTitle("FELICITATION");
			bravo.setHeaderText("Fin de la partie");
			bravo.setContentText(this.app.getJeu().getGagnant() + " a gagné la partie !");
			bravo.showAndWait();
		}
		
		if(this.app.getJeu().matcheNull()) {
			for(Button button : this.app.getLsB()) {
				button.setDisable(true);
			}
			this.app.getToursA().setText("");
			Alert MN = new Alert(AlertType.INFORMATION);
			MN.setTitle("La grille est remplie");
			MN.setHeaderText("Fin de la partie");
			MN.setContentText("C'est un matche null !");
			MN.showAndWait();
		}
	}

}
