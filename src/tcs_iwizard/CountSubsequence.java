package tcs_iwizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Dell
 *
 *Partially Accepted
 */
public class CountSubsequence {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String S = br.readLine();
		int Q = Integer.parseInt(br.readLine().trim());
		String[] arr = new String[Q];
		for(int i_arr=0; i_arr<Q; i_arr++)
		{
			arr[i_arr] = br.readLine();
		}

		int[] out_ = helpPrivateRyan(S, arr);
		System.out.print(out_[0]);
		for(int i_out_=1; i_out_<out_.length; i_out_++)
		{
			System.out.print(" " + out_[i_out_]);
		}

		wr.close();
		br.close();
	}
	
	static int[] helpPrivateRyan(String S, String[] arr){
		
		int[] subSeqArr = new int[arr.length];
		int count = 0;
		
		double modVal = Math.pow(10.0, 9.0) + 7;
		
		for(String ch : arr) {
			
			for(int i=0; i<S.length(); i++) {
				
				if(ch.equals(String.valueOf(S.charAt(i)))) {
					subSeqArr[count]+=1;
					subSeqArr[count] %= modVal;
				}
				
				for(int j=i+1; j<S.length(); j++) {
					if(ch.equals(String.valueOf(S.charAt(j)))) {
						subSeqArr[count]+=1;
						subSeqArr[count] %= modVal;
					}
				}
			}
		
			count++;
		}
		
		
		return subSeqArr;	
	}
}
