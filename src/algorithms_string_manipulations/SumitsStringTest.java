package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumitsStringTest {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		char[] chArr = null;
		boolean result = true;
		int ch1, ch2;
		
		while(T-- > 0) {
			
			chArr = br.readLine().toCharArray();
			result = true;
			
			for(int i=0; i<chArr.length-1; i++) {
				ch1 = (int)chArr[i];
				ch2 = (int)chArr[i+1];
				
				if(ch1 == 97) {
					if(! (ch2 == 96 || ch2 == 122 || ch2 == 98)) {
						result = false;
						break;
					}
				}else if(ch1 == 122) {
					if(! (ch2 == 97 || ch2 == 121)) {
						result = false;
						break;
					}
				}else {
					if(!((ch1 == ch2 + 1) || (ch1 == ch2 -1))) {
						result = false;
						break;
					}	
				}
			}
			
			
			if(result) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}	
		}
	}

}
