package greedy_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Dell
 *
 *Accepted
 */
public class ExploringRuins {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chrArr = br.readLine().toCharArray();

		int i = 0;
		
		//First Character
		if(chrArr.length > 1 && chrArr[i] == '?') {
			if(chrArr[i+1] == 'a') {
				chrArr[i] = 'b';
			}else {
				chrArr[i] = 'a';
			}
		}else if(chrArr[i] == '?'){
			chrArr[i] = 'a';
		}
		
		i++;
		
		//Second to Second last character.
		for( ; i<chrArr.length-1; i++) {
			
			if(chrArr[i] == '?') {
				if(chrArr[i-1] == 'a' || chrArr[i+1] == 'a') {
					chrArr[i] = 'b';
				}else {
					chrArr[i] = 'a';
				}
			}
		}
		
		//Last Character
		if(chrArr.length > 1  && chrArr[i] == '?') {
			if(chrArr[i-1] == 'a') {
				chrArr[i] = 'b';
			}else {
				chrArr[i] = 'a';
			}
		}
		
		System.out.println(new String(chrArr));
	}
	
}







