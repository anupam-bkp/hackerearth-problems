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

import org.omg.Messaging.SyncScopeHelper;

public class Festivals2 {
	
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
		int tempExp = 0;
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			expenseMap.clear();

			for(int i=0; i<N; i++) {
				split = br.readLine().split("\\s");
				expenseMap.putIfAbsent(split[0], getList());
				addToList(expenseMap.get(split[0]), Integer.parseInt(split[1]));
			}

			maxExp = 0;
			
			for(Entry<String, List<Integer>> entry : expenseMap.entrySet()) {

				key = entry.getKey();
				value = entry.getValue();
				
//				System.out.println(key + " " + value);
				
				tempExp = 0;
				for(Integer exp : value) {
					tempExp += exp;
				}
				
				if(tempExp > maxExp) {
					maxExp = tempExp;
					resultFest = key;
				}
			}

			System.out.println(resultFest + " " + maxExp);
		}
	}
	
	private static List<Integer> getList(){
		return new ArrayList<>(3);
	}
	
	private static void addToList(List<Integer> list, int val) {
		
		if(list.size() < 3) {
			list.add(val);
		}else {
			Collections.sort(list, Collections.reverseOrder());
			if(list.get(2) < val) {
				list.remove(2);
				list.add(val);
			}
		}
	}
	
}
