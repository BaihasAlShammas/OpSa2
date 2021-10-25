package gui;

import business.FreizeitBaederModel;
import javafx.stage.Stage;

public class FreizeitBaederControler {

	private FreizeitBaederModel freizeitBaederModel;
	private FreizeitBaederView freizeitBaederView;

	public FreizeitBaederControler(Stage primaryStage) {
		this.freizeitBaederModel = new FreizeitBaederModel();
		this.freizeitBaederView = new FreizeitBaederView(this, freizeitBaederModel, primaryStage);
	}

}
