package info.sudr.sandbox.forfeit;

import java.util.HashSet;
import java.util.Set;

public class GameInvoker {

	private final int limit;
	private final Rule rule;

	public GameInvoker(int limit, Rule rule) {
		this.rule = rule;
		this.limit = limit;
	}
	
	public Set<Integer> play() {
		Set<Integer> list = new HashSet<Integer>();
		for (int i = 1; i <= limit; i++) {
			if (rule.execute(i)) {
				list.add(i);
			}
		}
		return list;
	}
}
