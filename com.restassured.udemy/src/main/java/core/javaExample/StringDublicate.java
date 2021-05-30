package core.javaExample;

public class StringDublicate {

	public static void main(String[] args) {

		String name = "aabbccdd";
		int count =0;
		char ch [] = name.toCharArray();
		for (int i = 0; i < ch.length; i++) {
		for (int j = i+1; j < ch.length; j++) {
			
		if(ch[i]==ch[j]) {
			count ++;
		}
		
		
		}	
		System.out.println(ch[i]);
		}
		System.out.println(count);
	}

}
