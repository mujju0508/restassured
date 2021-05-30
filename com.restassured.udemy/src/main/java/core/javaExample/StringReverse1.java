package core.javaExample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.message.BufferedHeader;

import groovyjarjarantlr4.v4.runtime.ParserInterpreter;

public class StringReverse1 {

	public static void dublicateArray() {
		int[] arr = new int[] {10,20,30,40,40,10,50};
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]== arr[j]) {
					System.out.println(arr[j]);
				}
				
			}
			
		}
	}
	
	public static void prinmeExample(int no) throws NumberFormatException, IOException {
		int temp =0;
		
		for (int i = 0; i < no; i++) {
			for(int j=2;j<=i;j++) {
			if(i%2 ==0) {
				temp =temp+1;
			}
			}
			
			if(temp==0) {
				System.out.println("prime numbers are"+ i);
			}
			else {
				temp = 0;
			}
		}
		
	}
	
public static  void stringOccur(String name) {
	String name1=name.replace(" ", "");
	char [] ch =name1.toCharArray();
	HashMap<Character, Integer> hm = new HashMap<>();
	for(char c :ch) {
	if(hm.containsKey(c)) {
		hm.put(c, hm.get(c)+1);
	}
	else {
		hm.put(c, 1);
	}
	}
	
	System.out.println(name+hm);
	
}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
 String name = "Mohammad Muthubuddin";
 String [] rev = name.split("");
 for(int i=rev.length-1;i>=0;i--) {
	 System.out.println(rev[i]);
 }
 System.out.println("dbulicate arrays are : " );
 dublicateArray();
 stringOccur(name);
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("inter the number");
	int no = Integer.parseInt(br.readLine());
 prinmeExample(no);
	}

}
