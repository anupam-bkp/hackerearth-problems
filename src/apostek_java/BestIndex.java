package apostek_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Partially Accepted
 * @author Dell
 *
 */
public class BestIndex {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] inArr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer :: parseInt).toArray();

		int maxSum = 0;
		int count = 0;
		int sum = 0;
		int tempSum = 0;
		int tempCount = 0;

		for(int i=0; i<N; i++) {

			sum = 0;
			count = 0;

			for(int j=i; j<N;) {
				count++;

				if((j+count) <= N) {
					tempCount = count;
					tempSum = 0;
					while(tempCount-- > 0) {
						tempSum += inArr[j++];
					}

					sum += tempSum;

				}else {
					break;
				}
			}

			if(sum > maxSum) {
				maxSum = sum;
			}
		}
		
		System.out.println(maxSum);
	}
	
}
