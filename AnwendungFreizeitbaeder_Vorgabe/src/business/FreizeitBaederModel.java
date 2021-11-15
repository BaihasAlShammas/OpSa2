package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import csvExport.ConcreteCerator;
import csvExport.Creator;
import csvExport.Product;

public class FreizeitBaederModel {

	private Freizeitbad freizeitbad;

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	public void SchreibeFreizeitBaederInVsvDatei() throws IOException {
		
		Creator creator = new ConcreteCerator();
		Product writer = creator.factoryMethod();
		
		writer.fuegeInDateihinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

}
