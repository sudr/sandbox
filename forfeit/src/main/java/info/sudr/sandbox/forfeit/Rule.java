package info.sudr.sandbox.forfeit;

public class Rule {

	private final int n;

	public Rule(int n) {
		this.n = n;
	}

	public boolean execute() {
		return n % 7 != 0 ;
	}

}