package info.sudr.sandbox.forfeit.rule;

public class Util {

	public static int sumOfDigits(int n) {
		char[] charArray = String.valueOf(n).toCharArray();
		int sumOfDigits = 0;
		for (int i = 0; i < charArray.length; i++) {
			int val = Integer.valueOf(String.valueOf(charArray[i]));
			sumOfDigits += val;
		}
		return sumOfDigits;
	}
}
