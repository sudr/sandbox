package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class SumNotContainSeven extends RuleDecorator {

	public SumNotContainSeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		NotContainSeven notContainSeven = new NotContainSeven(new EmptyRule());
		int sumOfDigits = Util.sumOfDigits(n);
		return notContainSeven.execute(sumOfDigits) ? rule.execute(n) : false;
	}

}
