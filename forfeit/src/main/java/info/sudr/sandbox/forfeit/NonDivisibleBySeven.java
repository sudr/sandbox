package info.sudr.sandbox.forfeit;

public class NonDivisibleBySeven extends RuleDecorator {

	public NonDivisibleBySeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		if (n % 7 == 0) {
			return false;
		}
		return rule.execute(n);
	}

}
