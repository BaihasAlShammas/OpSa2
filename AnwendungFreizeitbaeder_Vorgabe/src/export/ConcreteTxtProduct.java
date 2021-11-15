package export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtProduct extends Product {

	BufferedWriter aus;

	public ConcreteTxtProduct() {
		try {

			aus = new BufferedWriter(new FileWriter("FreizeitBaeder.txt", true));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {

		Freizeitbad freizeitbad = (Freizeitbad) object;

		String txtExport = "Daten des Freizeitbades:\n" + "Name des FreizeitBades: " + freizeitbad.getName() + "\n"
				+ "Öffungszeit des FreiZeitbads: " + freizeitbad.getGeoeffnetVon() + " - "
				+ freizeitbad.getGeoeffnetBis() + "\n" + "Beckenlänge des Freizeitbads: "
				+ freizeitbad.getBeckenlaenge() + "\n" + "Wassertemperatur des Freizeitbades: "
				+ freizeitbad.getTemperatur() + "\n";

		aus.write(txtExport);
	}

	@Override
	public void schliesseDatei() throws IOException {

		aus.close();
	}

}
