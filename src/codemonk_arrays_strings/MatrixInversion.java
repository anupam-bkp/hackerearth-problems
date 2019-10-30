package codemonk_arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted
public class MatrixInversion {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		String[] dataArr;
		int[][] dataMatrix; 
		int data = 0;
		int numOfInv = 0;
		
		for(int t=0; t<T; t++) {
			
			numOfInv = 0;
			
			N = Integer.parseInt(br.readLine());
			dataMatrix = new int[N][N];
			
			for(int j=0; j<N; j++) {
				dataArr = br.readLine().split("\\s");
				
				for(int k=0; k<N; k++) {
					dataMatrix[j][k] = Integer.parseInt(dataArr[k]);
				} 
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					data = dataMatrix[i][j];
					
					for(int k=i; k<N; k++) {
						for(int l=j; l<N; l++) {
							if(data > dataMatrix[k][l]) {
								numOfInv++;
							}
						}
					}
				}
			}
			
			System.out.println(numOfInv);
		}
	}
}
