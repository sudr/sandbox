package info.sudr.sandbox.forfeit;

public class EmptyRule implements Rule {

	private final int n;

	public EmptyRule(int n) {
		this.n = n;
	}

	@Override
	public boolean execute() {
		return true;
	}

	@Override
	public int getN() {
		return n;
	}

}
