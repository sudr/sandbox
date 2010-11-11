package info.sudr.sandbox.forfeit;

public class NonDivisibleBySeven extends RuleDecorator {

	public NonDivisibleBySeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute() {
		if (rule.getN() % 7 == 0) {
			return false;
		}
		return rule.execute();
	}

}
