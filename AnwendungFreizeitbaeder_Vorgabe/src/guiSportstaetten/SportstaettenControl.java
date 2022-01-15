package guiSportstaetten;

import business.FreizeitBaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportView;
	private FreizeitBaederModel freiModel;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freiModel = FreizeitBaederModel.getModel();
		this.sporthallenModel = SporthallenModel.getModel();
		this.sportView = new SportstaettenView(this, fensterSportstaetten, freiModel, sporthallenModel);
		freiModel.addObserver(this);
	}

	@Override
	public void update() {
		sportView.zeigeFreizeitbaederAn();
	}

}
