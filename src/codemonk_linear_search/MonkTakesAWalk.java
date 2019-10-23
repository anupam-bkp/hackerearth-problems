package codemonk_linear_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *Accepted
 * 
 * @author Anupam
 *
 */
public class MonkTakesAWalk {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] chArr = null;
		int vowelCount;
		
		while(T-- > 0) {
			vowelCount = 0;
			chArr = br.readLine().toCharArray();
			for(char ch : chArr) {
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
						ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
					vowelCount++;
				}
			}
			
			System.out.println(vowelCount);	
		}
	}
}
