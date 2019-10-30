package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Festivals {
	
	public static void main(String args[]) throws IOException {
	
		Map<String, List<Integer>> expenseMap = new TreeMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		String[] split = null;
		
		String resultFest = "";
		int maxExp = 0;
		String key = "";
		List<Integer> value = null;
		int count = 1;
		int tempExp = 0;
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			expenseMap.clear();

			for(int i=0; i<N; i++) {
				split = br.readLine().split("\\s");
				expenseMap.putIfAbsent(split[0], new ArrayList<>());
				expenseMap.get(split[0]).add(Integer.parseInt(split[1]));				
			}

			maxExp = 0;
			
			for(Entry<String, List<Integer>> entry : expenseMap.entrySet()) {

				key = entry.getKey();
				value = entry.getValue();

				Collections.sort(value);

				count = 1;
				tempExp = 0;
				for(int i=value.size()-1; i>=0; i--) {

					if(count++ > 3) {
						break;
					}

					tempExp += value.get(i);
				}

				if(tempExp > maxExp) {
					resultFest = key;
					maxExp = tempExp;
				}	
			}

			System.out.println(resultFest + " " + maxExp);
		}
		
	}
	

}
