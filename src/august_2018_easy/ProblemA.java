package august_2018_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Pikachu and the game of Strings
 * @author Dell
 * 
 * Partially accepted
 *
 */
public class ProblemA {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] move_S = br.readLine().toCharArray();
		char[] move_t = br.readLine().toCharArray();
		
		int numOfDays = 0;
		int currCh = 0;
		int finalCh = 0;
		int tempCh = 0;
		
		for(int i=0; i<n; i++) {
	
//			System.out.println(move_S[i] + " : " + (int)move_S[i]);
//			System.out.println(move_t[i] + " : " + (int)move_t[i]);
			
			currCh = move_S[i] - 64;
			finalCh = move_t[i] - 64;
			
			System.out.println(move_S[i] + " : " + currCh);
			System.out.println(move_t[i] + " : " + finalCh);
			System.out.println("NumOfDays : " + numOfDays);
			
			while(currCh != finalCh) {
				
				if(finalCh > currCh) {
					tempCh = currCh + 13;
					if(finalCh >= tempCh) {
						currCh = tempCh;
						numOfDays++;
					}else {
						numOfDays = numOfDays + finalCh - currCh;
						currCh = finalCh;
					}
				}else {
					
					tempCh = (currCh + 13)%26;
					if(tempCh > finalCh) {
						numOfDays = numOfDays + (26 - currCh + finalCh);
						currCh = finalCh;
					}else {
						currCh = tempCh; 
						numOfDays++;
					}
				}
			}
		}
		
		System.out.println(numOfDays);
	}
	
}





