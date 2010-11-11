package info.sudr.sandbox.forfeit.rule;

import info.sudr.sandbox.forfeit.Rule;

public class EmptyRule implements Rule {

	@Override
	public boolean execute(int n) {
		return true;
	}

}
