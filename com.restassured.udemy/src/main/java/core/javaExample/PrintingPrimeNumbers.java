package core.javaExample;

public class PrintingPrimeNumbers {

	public static void main(String[] args) {
		int temp=0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j<=i; j++) {
				if(i%2==0) {
					
				 temp =temp+1;
				}
				
			}
			if(temp == 0) {
				System.out.println("prime numbers are"+ i);
			}
			else {
				temp =0;
			}
			
		}
		
	}
	
}
