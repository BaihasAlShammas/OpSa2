package guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitBaederModel;
import javafx.stage.Stage;

public class FreizeitBaederControler implements observer.Observer {

	private FreizeitBaederModel freizeitBaederModel;
	private FreizeitBaederView freizeitBaederView;

	public FreizeitBaederControler(Stage primaryStage) {
		this.freizeitBaederModel = FreizeitBaederModel.getTheInstance();
		this.freizeitBaederModel.addObserver(this);
		this.freizeitBaederView = new FreizeitBaederView(this, freizeitBaederModel, primaryStage);
	}

	public void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitBaederModel.SchreibeFreizeitBaederInVsvDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in csv Datei gespeichert");

			} else if ("txt".equals(typ)) {
				freizeitBaederModel.SchreibeFreizeitBaederInTxtDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in csv Datei gespeichert");
			} else {
				freizeitBaederView.zeigeInformationsfensterAn("Noch nihct implementiert");

			}
		} catch (IOException exc) {
			freizeitBaederView.zeigeInformationsfensterAn("IOException beim Speichern");
		} catch (Exception exc) {
			freizeitBaederView.zeigeInformationsfensterAn("Unbekannter Fehler beim Speichern");
		}
	}

	@Override
	public void update() {
		this.freizeitBaederView.zeigeFreizeitbaederAn();
	}

}
