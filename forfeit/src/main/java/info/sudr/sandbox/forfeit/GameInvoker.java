package info.sudr.sandbox.forfeit;

import java.util.SortedSet;
import java.util.TreeSet;

public class GameInvoker {

	private final int limit;
	private final Rule rule;

	public GameInvoker(int limit, Rule rule) {
		this.rule = rule;
		this.limit = limit;
	}
	
	public SortedSet<Integer> play() {
		SortedSet<Integer> list = new TreeSet<Integer>();
		for (int i = 1; i <= limit; i++) {
			if (rule.execute(i)) {
				list.add(i);
			}
		}
		return list;
	}
}
