package epsilon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Dell
 *
 *Partially accepted
 */
public class HarryAndString {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final String alphaOrder = "a*e*i*o*u*";
		final String revAlphaOrder = "u*o*i*e*a*";
		
		final Pattern alphaPattern = Pattern.compile(alphaOrder);
		final Pattern revAlphaPattern = Pattern.compile(revAlphaOrder);
		
		Matcher alphaMatcher = null;
		Matcher revAlphaMatcher = null;
		
		String vowelCollect = null;
		
		int T = Integer.parseInt(br.readLine());
		char[] spell = null;

		List<Character> vowelList = null;
		char currChar = ' ';
		
		while(T-- > 0) {
			spell = br.readLine().toCharArray();
			vowelList = new ArrayList<>();
			vowelCollect = "";

			for(int i=0; i<spell.length; i++) {
				currChar = spell[i];
				if(currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u') {
					vowelList.add(currChar);
				}
			}

			for(Character vowel : vowelList) {
				vowelCollect += vowel;
			}
			
			alphaMatcher = alphaPattern.matcher(vowelCollect);
			if(alphaMatcher.matches()) {
				System.out.println("Good");
			}else {
				revAlphaMatcher = revAlphaPattern.matcher(vowelCollect);
				if(revAlphaMatcher.matches()) {
					System.out.println("Worst");
				}else {
					System.out.println("Bad");
				}
			}
		}
	}

}
