package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FreizeitBaederModel {

	private Freizeitbad freizeitbad;

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	public void SchreibeFreizeitBaederInVsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("FreizeitBaeder.csv", true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();

	}

}
