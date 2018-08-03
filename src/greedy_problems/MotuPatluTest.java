package greedy_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class MotuPatluTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int N = 0;
		int motu_ice_ht = 0;
		int patlu_ice_ht = 0;
		int motu_count = 0;
		int patlu_count = 0;
		int motu_counter = 0;
		int patlu_counter = 0;
		int motu_rem_ht = 0;
		int patlu_rem_ht = 0;
		
		while(t-- > 0) {
			N = Integer.parseInt(br.readLine());
			int[] heightArr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer :: new).toArray();
			
			motu_counter = 0;
			patlu_counter = N-1;
		
			motu_rem_ht = 0;
			patlu_rem_ht = 0;
			
			motu_count = 0;
			patlu_count = 0;
			
			while(N > 0) {	
		
				if(motu_rem_ht == 0) {
					motu_ice_ht = heightArr[motu_counter];
					N--; motu_count++;
				}else {
					motu_ice_ht = motu_rem_ht;
				}
				
				if(patlu_counter == motu_counter) {
					break;
				}
				
				if(patlu_rem_ht == 0) {
					patlu_ice_ht = 2 * heightArr[patlu_counter];
					N--; patlu_count++;
				}else {
					patlu_ice_ht = patlu_rem_ht;
				}
				
				if(motu_ice_ht == patlu_ice_ht) {
					motu_rem_ht = 0; patlu_rem_ht = 0;
					motu_counter++; patlu_counter--;
				}else if(motu_ice_ht > patlu_ice_ht) {
					motu_rem_ht = motu_ice_ht - patlu_ice_ht;
					patlu_rem_ht = 0; patlu_counter--;
				}else {
					patlu_rem_ht = patlu_ice_ht - motu_ice_ht;
					motu_rem_ht = 0; motu_counter++;
				}
			}
		
			System.out.println(motu_count + " " + patlu_count);
			if(motu_count > patlu_count) {
				System.out.println("Motu");
			}else if(motu_count < patlu_count){
				System.out.println("Patlu");
			}else {
				System.out.println("Tie");
			}
			
		}
		
	}
	
}
