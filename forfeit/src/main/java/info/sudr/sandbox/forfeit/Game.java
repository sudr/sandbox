package info.sudr.sandbox.forfeit;

import info.sudr.sandbox.forfeit.rule.EmptyRule;
import info.sudr.sandbox.forfeit.rule.NonDivisibleBySeven;
import info.sudr.sandbox.forfeit.rule.NotContainSeven;

import java.util.SortedSet;

public class Game {

	public SortedSet<Integer> play(int limit) {
		if (limit < 1) {
			throw new RuntimeException("limit must be greater than 0");
		}

		Rule rule = new NonDivisibleBySeven(new EmptyRule());
		rule = new NotContainSeven(rule);
		GameInvoker invoker = new GameInvoker(limit, rule);
		return invoker.play();
	}
}
