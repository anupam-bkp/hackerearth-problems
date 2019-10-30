package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class HighestAverage {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split("\\s");
		long[] arr = Stream.of(strArr).mapToLong(Long :: parseLong).toArray();
		
		int Q = Integer.parseInt(br.readLine());
		long k = 0;
		
		int maxSubsetSize = 0;
		int subsetSize = 0;
		long temp = 0;
		int count = 0;
		
		while(Q-- > 0) {
			k = Long.parseLong(br.readLine());
			
			maxSubsetSize = 0;
			count = 0;
			
			for(int i=0; i<N; i++) {		
				if(arr[i] < k) {
					subsetSize = 1;
					temp = arr[i];
					count = 1;
				}else {
					continue;
				}
				
				for(int j=i+1; j<N; j++) {
					temp += arr[j];
					if((temp/(++count)) < k) {
						subsetSize++;
					}else {
						break;
					}
					
				}
				
				if(subsetSize > maxSubsetSize) {
					maxSubsetSize = subsetSize;
				}
				
				if(maxSubsetSize == N) {
					break;
				}
			}
			
			System.out.println(maxSubsetSize);
		}
		
	}
	
}
