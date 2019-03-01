
public class question1 {

	public static void main(String[] args) {
		String sentence = "asdfg?jklqwertyu?io";
		//char[] chars = sentence.toCharArray();
		//boolean flag = true;
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			for(int j = i + 1; j < sentence.length(); j++) {
				char d = sentence.charAt(j);
				if(c == d) {
					//flag = false;
					System.out.println(c + " " + d);
					System.out.println("fails");
					System.exit(1);
				}
				System.out.println(c + " " + d);
				
			}
		}
	}
}
