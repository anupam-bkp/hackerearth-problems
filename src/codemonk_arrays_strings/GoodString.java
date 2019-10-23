package codemonk_arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Accepted
 * @author Anupam
 *
 */
public class GoodString {
	
	public static void main(String[] args)  throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String str = br.readLine();
		final int length = str.length();
		
		List<Character> charList = Arrays.asList('a', 'e', 'i', 'o', 'u');
				
		int goodLen = 0;
		String tempStr;
		int finalGoodLen = 0;
		
		for(int i=0; i<length; i++) {
			tempStr = str.substring(i);
			goodLen = 0;
			for(int j=0; j<tempStr.length(); j++) {
				if(!charList.contains(tempStr.charAt(j))){
					break;
				}else {
					goodLen++;
				}
			}
			
			if(goodLen > finalGoodLen) {
				finalGoodLen = goodLen;
			}
			
			if(goodLen == length - i) {
				break;
			}
			
		}
		
		System.out.println(finalGoodLen);
		
	}

}
