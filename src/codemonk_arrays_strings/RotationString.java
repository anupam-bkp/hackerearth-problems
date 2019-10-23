package codemonk_arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Partially Accepted
 * 
 * @author Anupam
 *
 */
public class RotationString {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int arrLen = 0;
		String[] NK = null;
		String[] arr = null;
		int K = 0 ;
		
		while(T-- > 0) {
			NK = br.readLine().split("\\s");
			arrLen = (Integer.parseInt(NK[0]));
			K = (Integer.parseInt(NK[1]));
			arr = br.readLine().split("\\s");
			
			if(K > arrLen) {
				K = K % arrLen;
			}
			
			K = arrLen - K;
			
			for(int i = K; i<arrLen; i++) {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			
			for(int i = 0; i<K; i++) {
				System.out.print(arr[i]);
				if(i<K-1)
					System.out.print(" ");
			}	
		}
	}

}
