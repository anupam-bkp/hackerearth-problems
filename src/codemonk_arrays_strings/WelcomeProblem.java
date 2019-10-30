package codemonk_arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Accepted
public class WelcomeProblem {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		/*String strArr1[] = br.readLine().split("\\s");
		String strArr2[] = br.readLine().split("\\s");
*/
		int[] intArr1 = new int[n];
		int[] intArr2 = new int[n];
		
		int i = 0;
		
		for(String str : br.readLine().split("\\s")) {
			intArr1[i++] = Integer.parseInt(str); 
		}
		
		i = 0;
		
		for(String str : br.readLine().split("\\s")) {
			intArr2[i++] = Integer.parseInt(str); 
		}
		
		System.out.println(n);
		System.out.println(Arrays.toString(intArr1));
		System.out.println(Arrays.toString(intArr2));
		
		i = 0;
		
		/*for(i=0; i<n-1; i++) {
			System.out.print(Integer.parseInt(strArr1[i]) + Integer.parseInt(strArr2[i]));
			System.out.print(" ");
		}
			System.out.print(Integer.parseInt(strArr1[i]) + Integer.parseInt(strArr2[i]));
		*/
		
		for(i=0; i<n-1; i++) {
			System.out.print(intArr1[i] + intArr2[i]);
			System.out.print(" ");
		}
		
		System.out.print(intArr1[i] + intArr2[i]);
	}
	
}