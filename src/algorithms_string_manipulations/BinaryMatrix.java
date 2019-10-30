package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BinaryMatrix {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().split("\\s")[0]);
		
		BigInteger maxVal = new BigInteger(br.readLine(), 10);
		int index = 1;
		BigInteger currVal;
		
		for(int i=2; i<=N; i++){
			currVal = new BigInteger(br.readLine(), 10);
			
			if(currVal.compareTo(maxVal) == 1) {
				maxVal = currVal;
				index = i;
			}
		}
		
		System.out.println(index);
	}

}
