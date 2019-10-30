package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GreatestString {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		final Map<Character, Character> vowelsMap = new HashMap<>();
		vowelsMap.put('a', 'b'); vowelsMap.put('e', 'f'); vowelsMap.put('i', 'j');
		vowelsMap.put('o', 'p'); vowelsMap.put('u', 'v');
		
		char[] chrArr = null;
		int Q = 0;
		int currLoc = 0;
		int strLen = 0;
		
		while(T-- > 0) {
		
			chrArr = br.readLine().toCharArray();
			strLen = chrArr.length;
			Q = Integer.parseInt(br.readLine());
			currLoc = 0;
			
			while(Q-- > 0){
				
				while(currLoc < strLen) {
					
					if(vowelsMap.containsKey(chrArr[currLoc])){
						chrArr[currLoc] = vowelsMap.get(chrArr[currLoc]);
						currLoc++;
						break;
					}
					
					currLoc++;
				}
				
				if(currLoc == strLen) {
					break;
				}
				
			}
			
			System.out.println(new String(chrArr));
		}
		
	}
	
}
