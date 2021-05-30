package core.javaExample;

public class StringReverse {

	public static void main(String[] args) {
		
String name = "Hello World";

String [] rev = name.split("");
for(int i=rev.length-1;i>=0;i--) {
	System.out.println(rev[i]);
}
	}
	
	
}
