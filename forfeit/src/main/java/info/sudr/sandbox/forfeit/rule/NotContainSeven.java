package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class NotContainSeven extends RuleDecorator {

	public NotContainSeven(Rule rule) {
		super(rule);
	}

	@Override
	public boolean execute(int n) {
		return String.valueOf(n).contains("7") ? false : rule.execute(n);
	}

}
