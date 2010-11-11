package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class SumNonDivisibleBySeven extends RuleDecorator {

	public SumNonDivisibleBySeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		NonDivisibleBySeven nonDivisibleBySeven = new NonDivisibleBySeven(new EmptyRule());
		char[] charArray = String.valueOf(n).toCharArray();
		int sumOfDigits = 0;
		for (int i = 0; i < charArray.length; i++) {
			int val = Integer.valueOf(String.valueOf(charArray[i]));
			sumOfDigits += val;
		}
		return nonDivisibleBySeven.execute(sumOfDigits) ? rule.execute(n) : false;
	}

}
