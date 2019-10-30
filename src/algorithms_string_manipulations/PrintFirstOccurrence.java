package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Anupam 
 * 
 * Accepted
 */
public class PrintFirstOccurrence {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		char[] chArr = null;
		Set<Character> charSet = new LinkedHashSet<>();
		String result = null;
		
		while(T-- > 0) {
			
			chArr = br.readLine().toCharArray();
			charSet.clear();
			
			for(char ch : chArr) {
				charSet.add(ch);
			}
			
			result = "";
			for(Character ch : charSet) {
				result += ch;
			}	
			
			System.out.println(result);
		}
	}

}
