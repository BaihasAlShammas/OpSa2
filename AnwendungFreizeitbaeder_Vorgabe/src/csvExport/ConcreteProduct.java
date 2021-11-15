package csvExport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteProduct extends Product {
	
	BufferedWriter aus;
	
	public ConcreteProduct() {
		try {
			
			aus = new BufferedWriter(new FileWriter("FreizeitBaeder.csv", true));
		}catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public void fuegeInDateihinzu(Object object) throws IOException {
		
		aus.write(((Freizeitbad)object).gibFreizeitbadZurueck(';'));
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		aus.close();
	}

}
