package core.javaExample;

import java.util.HashMap;

public class StringOccurence {

	public static void main(String[] args) {
	
		String name = "hello mohammad";
		char[] ch = name.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for(char c:ch) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		
		System.out.println(name +hm);
		
	}

}
