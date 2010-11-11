package info.sudr.sandbox.forfeit;

import java.util.Set;

public class Game {

	public Set<Integer> play(int limit) {
		if (limit < 1) {
			throw new  RuntimeException("limit must be greater than 0");
		}
		
		Rule rule = new NonDivisibleBySeven(new EmptyRule());
		GameInvoker invoker = new GameInvoker(limit, rule);
		return invoker.play();
	}
}
