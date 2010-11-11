package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public abstract class RuleDecorator implements Rule {

	protected final Rule rule;

	public RuleDecorator(Rule rule) {
		this.rule = rule;
	}
	
}
