package info.sudr.sandbox.predicates;

/**
 * Represents a customer
 * 
 * @author cyrille martraire
 */
public final class Customer {

	private final String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
