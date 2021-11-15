package csvExport;

public class ConcreteCerator extends Creator {

	@Override
	public Product factoryMethod() {
		return new ConcreteProduct();
	}
}
