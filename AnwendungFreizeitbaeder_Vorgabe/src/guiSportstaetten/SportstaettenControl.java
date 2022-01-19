package guiSportstaetten;

import java.io.IOException;
import business.FreizeitBaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportView;
	private FreizeitBaederModel freiModel;
	private SporthallenModel sporthallenModel;
	SportstaettenView sportstaettenView;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freiModel = FreizeitBaederModel.getModel();
		this.sporthallenModel = SporthallenModel.getModel();
		this.sportView = new SportstaettenView(this, fensterSportstaetten, freiModel, sporthallenModel);
		freiModel.addObserver(this);
	}

	public void leseSporthallenAusCsvDatei() {
		
		try {
			
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			sportstaettenView.zeigeInformationsfensterAn("IO Exception");
		} catch (PlausiException e1) {
			// TODO Auto-generated catch block
			sportstaettenView.zeigeInformationsfensterAn("PlusiException Exception");
		}
	}

	@Override
	public void update() {
		sportView.zeigeFreizeitbaederAn();
	}
}
