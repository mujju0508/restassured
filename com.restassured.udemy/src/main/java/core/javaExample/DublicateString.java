package core.javaExample;

import java.util.Iterator;

public class DublicateString {

	public static void main(String[] args) {
		String sentence = "hello i works on selenium java selenium ";
		String word[] =sentence.split(" "
				+ "");
		int count =0;
		for (int i = 0; i < word.length; i++) {
			count =1;
			for (int j = i+1; j < word.length; j++) {
				if(word[i].equals(word[j])){
					count++;
					word[j]="0";
				}
			}
			if(count>1 && word[i]!="0") {
				System.out.println(word[i]);
			}
		}
		
	}
	
}
