package core.javaExample;

public class DublicateArray {

	public static void main(String[] args) {
int[] arr = new int[] {10,1,5,6,5,2,1,2};
for(int i = 0; i < arr.length; i++) {  
    for(int j = i + 1; j < arr.length; j++) {  
        if(arr[i] == arr[j])  
            System.out.println(arr[j]);  
	}
}
	}

}
