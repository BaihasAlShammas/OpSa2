package guiSportstaetten;

import business.FreizeitBaederModel;
import javafx.stage.Stage;

public class SportstaettenControl implements observer.Observer {
	private SportstaettenView sportstaettenView;
	private FreizeitBaederModel freizeitbaederModel;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = freizeitbaederModel.getTheInstance();
		this.freizeitbaederModel.addObserver(this);
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel);
	}

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}
