import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		String s = "qwerty12345!@#$%";
		Set<Character> jSet = new HashSet<>();
		for(Character ch : s.toCharArray()) {
			jSet.add(ch);
		}
	}

}
