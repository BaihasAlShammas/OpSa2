package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import business.businessSporthallen.Sporthalle;
import ownUtil.PlausiException;

public class SporthallenModel {

	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private static SporthallenModel instanceModel;

	private SporthallenModel() {
	}

	public static SporthallenModel getModel() {
		if (instanceModel == null)
			instanceModel = new SporthallenModel();

		return instanceModel;
	}

	public ArrayList<Sporthalle> getSporthallen() {
		return sporthallen;
	}

	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthallen = ergebnis;
	}
}