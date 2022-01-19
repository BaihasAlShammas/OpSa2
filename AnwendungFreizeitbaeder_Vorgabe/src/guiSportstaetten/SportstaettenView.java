package guiSportstaetten;

import business.FreizeitBaederModel;
import business.Freizeitbad;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;
import javafx.scene.control.Alert.AlertType;

public class SportstaettenView {

	private FreizeitBaederModel freiModel;
	private SporthallenModel sporthallenModel;
	private SportstaettenControl sportstaettenControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();

	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitb�der");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");

	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("CSV Import und Anzeige");

	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportControl, Stage fenstersportstaetten,
			FreizeitBaederModel freiModel, SporthallenModel sporthallenModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		fenstersportstaetten.setScene(scene);
		fenstersportstaetten.setTitle("Anzeige von Sportst�tten");
		fenstersportstaetten.setX(100);
		fenstersportstaetten.show();

		this.freiModel = freiModel;
		this.sporthallenModel = sporthallenModel;
		this.sportstaettenControl = sportControl;

		this.initKomponentenFreizeitbaeder();
		initKomponentenSporthallen();
		this.initListener();
	}

	private void initKomponentenFreizeitbaeder() {

		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);

	}

	private void initKomponentenSporthallen() {

		Font font = new Font("Arial", 20);
		lblAnzeigeSporthallen.setLayoutX(20);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);
		// Textbereich
		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(20);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);
		// Button
		btnAnzeigeSporthallen.setLayoutX(20);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen);
	}

	private void initListener() {
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});

		btnAnzeigeSporthallen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				sportstaettenControl.leseSporthallenAusCsvDatei();
				zeigeSporthallenAn();
			}
		});
	}

	public void zeigeFreizeitbaederAn() {
		if (freiModel.getFreizeitbaeder().size() > 0) {
			StringBuffer text = new StringBuffer();

			for (Freizeitbad fzb : freiModel.getFreizeitbaeder()) {
				text.append(fzb.gibFreizeitbadZurueck("") + "\n");
			}
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	public void zeigeSporthallenAn() {
		if (sporthallenModel.getSporthallen().size() > 0) {
			StringBuffer text = new StringBuffer();

			for (Sporthalle sh : sporthallenModel.getSporthallen()) {
				text.append(sh.gibSporthalleZurueck(' ') + "\n");
			}
			this.txtAnzeigeSporthallen.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Sporthallen aufgenommen!");
		}
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

}
