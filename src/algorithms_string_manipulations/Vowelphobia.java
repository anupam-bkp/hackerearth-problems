package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Anupam
 * 
 * Accepted
 *
 */
public class Vowelphobia {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		char[] chArr = null;
		int count = 0;
		
		while(T-- > 0) {
			
			chArr = br.readLine().toCharArray();
			count = 0;
			
			for(char ch : chArr) {
				
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
