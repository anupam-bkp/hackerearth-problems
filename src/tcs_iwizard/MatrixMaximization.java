package tcs_iwizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dell
 *
 *Partially Accepted
 */
public class MatrixMaximization {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split("\\s");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);

		int totalSum = 0;
		int rowColTempSum = 0;
		int val = 0;

		int[][] matrix = new int[M][N];

		final Set<Integer> rowsToConsider = new HashSet<>();
		final Set<Integer> colsToConsider = new HashSet<>();

		for(int i=0; i<M; i++) {
			input = br.readLine().split("\\s");
			for(int j=0; j<N; j++) {
				val = Integer.parseInt(input[j]);
				matrix[i][j] = val;
				totalSum += val;
				if(val < 0) {
					rowsToConsider.add(i);
					colsToConsider.add(j);
				}
			}
		}

		int finalSum = totalSum;
		int tempSum = 0;

		for(Integer row : rowsToConsider) {

			rowColTempSum = 0;

			for(int col=0; col<N; col++) {
				rowColTempSum += matrix[row][col];
			}

			tempSum = totalSum - rowColTempSum;

			if(tempSum > finalSum) {
				finalSum = tempSum;
			}
		}

		for(Integer col : colsToConsider) {

			rowColTempSum = 0;

			for(int row=0; row<M; row++) {
				rowColTempSum += matrix[row][col];
			}

			tempSum = totalSum - rowColTempSum;

			if(tempSum > finalSum) {
				finalSum = tempSum;
			}
		}

		System.out.println(finalSum);
		
	}
	
}
