package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class NonDivisibleBySeven extends RuleDecorator {

	public NonDivisibleBySeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		return n % 7 == 0 ? false : rule.execute(n);
	}

}
