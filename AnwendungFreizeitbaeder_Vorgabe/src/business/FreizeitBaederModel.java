package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import export.ConcreteCsvCerator;
import export.ConcreteTxtCreator;
import export.Creator;
import export.Product;

public class FreizeitBaederModel {

	private Freizeitbad freizeitbad;

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	public void SchreibeFreizeitBaederInVsvDatei() throws IOException {

		Creator creator = new ConcreteCsvCerator();
		Product writer = creator.factoryMethod();

		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

	public void SchreibeFreizeitBaederInTxtDatei() throws IOException {

		Creator creator = new ConcreteTxtCreator();
		Product writer = creator.factoryMethod();

		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();

	}

}
