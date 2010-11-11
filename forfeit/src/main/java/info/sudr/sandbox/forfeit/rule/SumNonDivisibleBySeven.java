package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class SumNonDivisibleBySeven extends RuleDecorator {

	public SumNonDivisibleBySeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		NonDivisibleBySeven nonDivisibleBySeven = new NonDivisibleBySeven(new EmptyRule());
		int sumOfDigits = Util.sumOfDigits(n);
		return nonDivisibleBySeven.execute(sumOfDigits) ? rule.execute(n) : false;
	}

}
