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
		
		aus.write(((Freizeitbad)object).gibFreizeitbadZurueck("\n"));
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		aus.close();
	}

}
