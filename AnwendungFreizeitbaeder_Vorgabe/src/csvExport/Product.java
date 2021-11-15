package csvExport;

import java.io.IOException;

public abstract class Product {

	public abstract void fuegeInDateihinzu(Object object) throws IOException;

	public abstract void schliesseDatei() throws IOException;
}
