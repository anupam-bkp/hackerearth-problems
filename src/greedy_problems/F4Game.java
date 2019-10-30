package greedy_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F4Game {

	public static void main(String[] args) throws IOException{

		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int N = 0;
		int[][] numArr = null;
		int[] arr = null;
		
		final List<Integer> altF4List = new ArrayList<>();
		final List<Integer> ctrlF4List = new ArrayList<>();
		List<Integer> remainingPos = null;
		
		int altF4Result = 0;
		int ctrlF4Result = 0;
		
		int tempMaxVal = 0;
		int maxVal = 0;
		int selectedPos = 0;
				
		while(t-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			altF4List.clear();
			ctrlF4List.clear();
			altF4Result = 0;
			ctrlF4Result = 0;
			
			remainingPos = IntStream.range(0, N)
					.collect(ArrayList :: new, List :: add, (x, y) -> {});
			
//			System.out.println("Remaining Positions : " + remainingPos);
			
			numArr = new int[N][N];
		
			for(int i=0; i<N; i++){
				arr = Stream.of(br.readLine().split("\\s")).mapToInt(Integer :: new).toArray();
				numArr[i] = arr;
			}
			
			while(!remainingPos.isEmpty()) {
				/*
				System.out.println("Remaining Positions" + remainingPos);
				System.out.println("AltF4List : "  + altF4List);
				System.out.println("CtrlF4List : " + ctrlF4List);*/
				maxVal = 0;
				tempMaxVal = 0;
				
				for(Integer pos : remainingPos) {
					tempMaxVal = numArr[pos][pos];
					for(Integer availPos : altF4List) {
						tempMaxVal += numArr[pos][availPos];
						tempMaxVal += numArr[availPos][pos];
					}
					
					if(tempMaxVal >= maxVal) {
						selectedPos = pos;
						maxVal = tempMaxVal;
					}
				}
				
				altF4List.add(selectedPos);
				remainingPos.remove(new Integer(selectedPos));
				altF4Result += maxVal;
				
				if(remainingPos.isEmpty()) {
					break;
				}
				
				maxVal = 0;
				tempMaxVal = 0;
				
				for(Integer pos : remainingPos) {
					tempMaxVal = numArr[pos][pos];
					for(Integer availPos : ctrlF4List) {
						tempMaxVal += numArr[pos][availPos];
						tempMaxVal += numArr[availPos][pos];
					}
					
					if(tempMaxVal >= maxVal) {
						selectedPos = pos;
						maxVal = tempMaxVal;
					}
				}
				
				ctrlF4List.add(selectedPos);
				remainingPos.remove(new Integer(selectedPos));
				ctrlF4Result += maxVal;
			}
		
		/*	altF4Result = 0;
			ctrlF4Result = 0;
		
			System.out.println("AltF4List : "  + altF4List);
			System.out.println("CtrlF4List : " + ctrlF4List);
			
//			System.out.println("======================Printing for ALTF4 : =================");
			for(Integer pos : altF4List) {
				for(Integer pos1 : altF4List) {
					altF4Result += numArr[pos][pos1];
//					System.out.println(pos + " : " + pos1 + " : "+ altF4Result);
				}
			}
			
//			System.out.println("======================Printing for CTRLF4 : =================");
			
			for(Integer pos : ctrlF4List) { 
				for(Integer pos1 : ctrlF4List) {
					ctrlF4Result += numArr[pos][pos1];
//					System.out.println(pos + " : " + pos1 + " : " + ctrlF4Result);j
				}
			}*/
			
			System.out.println(altF4Result + " " + ctrlF4Result);
			/*int bothVal = altF4Result + ctrlF4Result;
			System.out.println("BothVal : " + bothVal);*/
		}
		
		
	}

}
