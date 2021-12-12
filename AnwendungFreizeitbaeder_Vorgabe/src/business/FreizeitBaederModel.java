package business;

import java.io.IOException;
import java.util.ArrayList;
import export.ConcreteCsvCerator;
import export.ConcreteTxtCreator;
import export.Creator;
import export.Product;
import observer.Observer;

public class FreizeitBaederModel implements observer.Observable {

	private Freizeitbad freizeitbad;
	private static FreizeitBaederModel theInstance = null;
	private ArrayList<Observer> observerss = new ArrayList<Observer>();

	private FreizeitBaederModel() {

	}

	public static FreizeitBaederModel getTheInstance() {
		if (theInstance == null)
			theInstance = new FreizeitBaederModel();
		return theInstance;
	}

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		notifyObservers();
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

	@Override
	public void addObserver(Observer obs) {
		observerss.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observerss.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerss.size(); i++) {
			observerss.get(i).update();
		}
	}
}
