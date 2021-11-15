package export;

public class ConcreteCsvCerator extends Creator {

	@Override
	public Product factoryMethod() {
		return new ConcreteCsvProduct();
	}
}
