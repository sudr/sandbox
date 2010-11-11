package info.sudr.sandbox.forfeit;

import java.util.HashSet;
import java.util.Set;

public class Game {

	private final int limit;

	public Game(int limit) {
		if (limit < 1) {
			throw new  RuntimeException("limit must be greater than 0");
		}
		this.limit = limit;
	}
	
	public Set<Integer> play() {
		Set<Integer> list = new HashSet<Integer>();
		for (int i = 1; i <= limit; i++) {
			Rule rule = new NonDivisibleBySeven(new EmptyRule(i));
			if (rule.execute()) {
				list.add(i);
			}
		}
		return list;
	}
}
