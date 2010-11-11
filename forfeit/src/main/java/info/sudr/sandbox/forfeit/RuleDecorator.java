package info.sudr.sandbox.forfeit;

public abstract class RuleDecorator implements Rule {

	protected final Rule rule;

	public RuleDecorator(Rule rule) {
		this.rule = rule;
	}
	
	public int getN() {
		return rule.getN();
	}

}
