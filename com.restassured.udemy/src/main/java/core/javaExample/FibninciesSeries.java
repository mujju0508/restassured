package core.javaExample;

public class FibninciesSeries {

	public static void main(String[] args) {
		int a=0,b=1,sum=0,n=10,temp=0;
		for(int i=0;i<n;i++) {
			sum =a+b;
			System.out.println(sum);
			a=b;
			b=sum;
		}
	
		
		
	}
}