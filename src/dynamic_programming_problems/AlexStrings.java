package dynamic_programming_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlexStrings {

	public static void main(String[] args) throws IOException{
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String newStr = "";
		int k = Integer.parseInt(br.readLine());
		
		String X = "";
		int index = 0;
		int val = 0;
		int tempVal = 0;
		
		while(str.length() >= k) {
			
			val = str.charAt(0);
			index = 0;
			
			for(int i=1; i<k; i++) {
				tempVal = str.charAt(i);
				if(tempVal < val) {
					val = tempVal;
					index = i;
				}
			}	
			
			X = X + str.charAt(index);
			
			newStr = "";
			
			if(index == 0) {
				newStr = str.substring(1);
			}else {
				newStr = str.substring(0, index);
				newStr += str.substring(index+1);
			}
			
			str = newStr;
		}
		
		final StringBuilder collect = str.chars().sorted().collect(StringBuilder :: new, 
				(t, value) -> t.append((char)value), (t, u) -> {});
		
		X += collect.toString();
		System.out.println(X);
	}
	
}
