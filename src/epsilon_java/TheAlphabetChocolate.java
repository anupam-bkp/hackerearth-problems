package epsilon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Dell
 *
 *Partially Accepted
 */
public class TheAlphabetChocolate {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		char[] spell = null;
		char currChar = ' ';
		
		List<Integer> vowelPosList = null;
		int tasteSum = 0;
		int currTaste = 0;
		
		while(T-- > 0) {
			spell = br.readLine().toCharArray();
			
			vowelPosList = new ArrayList<>();
			tasteSum = 0;
			
			for(int i=0; i<spell.length; i++) {
				currChar = spell[i];
				if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u'
						|| currChar == 'A' || currChar == 'E' || currChar == 'I' || currChar == 'O' || currChar == 'U') {
					vowelPosList.add(i);
				}
			}
			
			for(int i=0; i<spell.length; i++) {

				currTaste = 0;
				
				if(vowelPosList.contains(i)) {
					currTaste = 1;
					tasteSum += currTaste;					
				}

				for(int j=i+1; j<spell.length; j++) {
					if(vowelPosList.contains(j)) {
						currTaste += 1;
					}
						tasteSum += currTaste;
				}
			}
			
			System.out.println(tasteSum);
		}
		
	}
}
