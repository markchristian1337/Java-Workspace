abstract class Human{
	abstract public void help();
}

class Man extends Human {
	public void help() {
		System.out.println("man helping...");
	}
}

class Woman extends Human{
	public void help() {
		System.out.println("woman helping...");
	}
}

public class Sample {
	public static void seekHelpFrom(Human helper) {
		helper.help();
	}

	public static void main(String[] args) {
		Man bob = new Man();
		
		seekHelpFrom(bob);
		
		Woman sarah = new Woman();
		
		seekHelpFrom(sarah);
 
	}

}
