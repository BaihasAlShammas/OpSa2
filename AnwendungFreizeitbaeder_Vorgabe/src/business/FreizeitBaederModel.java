package business;

import java.io.IOException;
import java.util.ArrayList;
import export.ConcreteCsvCerator;
import export.ConcreteTxtCreator;
import export.Creator;
import export.Product;
import observer.Observer;

public class FreizeitBaederModel implements observer.Observable {

	private ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<Freizeitbad>();
	private static FreizeitBaederModel theInstance = null;
	private ArrayList<Observer> observerss = new ArrayList<Observer>();
	private static FreizeitBaederModel instanceModel;

	private FreizeitBaederModel() {

	}

	public static FreizeitBaederModel getModel() {
		if (instanceModel == null)
			instanceModel = new FreizeitBaederModel();

		return instanceModel;
	}

	public static FreizeitBaederModel getTheInstance() {
		if (theInstance == null)
			theInstance = new FreizeitBaederModel();
		return theInstance;
	}

	public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return freizeitbaeder;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		freizeitbaeder.add(freizeitbad);
		notifyObservers();
	}

	public void SchreibeFreizeitBaederInVsvDatei() throws IOException {

		if (freizeitbaeder.size() > 0) {
			Creator creator = new ConcreteCsvCerator();
			Product writer = creator.factoryMethod();

			for (Freizeitbad freizeitbad : freizeitbaeder) {
				writer.fuegeInDateiHinzu(freizeitbad);
			}
			writer.schliesseDatei();
		}

	}

	public void SchreibeFreizeitBaederInTxtDatei() throws IOException {

		if (freizeitbaeder.size() > 0) {
			Creator creator = new ConcreteTxtCreator();
			Product writer = creator.factoryMethod();

			for (Freizeitbad freizeitbad : freizeitbaeder) {
				writer.fuegeInDateiHinzu(freizeitbad);
			}
			writer.schliesseDatei();
		}
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
