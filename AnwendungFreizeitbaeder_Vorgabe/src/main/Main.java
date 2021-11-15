package main;

import gui.FreizeitBaederControler;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new FreizeitBaederControler(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
