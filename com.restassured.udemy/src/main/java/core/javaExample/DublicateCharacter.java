package core.javaExample;

public class DublicateCharacter {

	public static void main(String[] args) {
		String name ="mohammad";
		char [] ch =name.toCharArray();
		System.out.println(name.charAt(2));
		int count =0;
		for (int i = 0; i < ch.length; i++) {
			for (int j = i+1; j < ch.length; j++) {
				if(ch[i]==ch[j]) {
					
					System.out.println(ch[j]);
					count++;
					break;
				}
			}
			
		}
	}

}
