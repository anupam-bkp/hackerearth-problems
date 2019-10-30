package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * 
 * @author Dell
 *
 *Partially Accepted 
 *Time limit exceeded.
 */
public class OneValue {
	
	public static void main(String[] args) throws IOException {

		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		final Map<String, Integer> countMap  = new HashMap<>();  
		
		String[] str = null;
		
		while(M-- > 0) {
			str = br.readLine().split("\\s");
						
			if(str[0].equals("1")) {
				add_to_list(countMap, str[1]);
			}else if(str[0].equals("2")) {
				remove_from_list(countMap, str[1]);
			}else if(str[0].equals("3")) {
				find_least_frequency(countMap);
			}else if(str[0].equals("4")) {
				find_highest_frequency(countMap);
			}
		}		
	}
	
	private static void add_to_list(Map<String, Integer> countMap, String val){
/*		if(countMap.containsKey(val)) {
			countMap.replace(val, countMap.get(val) + 1);
		}else {
			countMap.put(val, 1);
		}
*/
		countMap.merge(val, 1, (t, u) -> t+u);
    }

	private static void remove_from_list(Map<String, Integer> countMap, String val){
    	if(countMap.containsKey(val)) {
			countMap.replace(val, countMap.get(val) - 1);
			if(countMap.get(val) <= 0) {
				countMap.remove(val);
			}
		}    	
    }

    public static void find_least_frequency(Map<String, Integer> countMap){
		OptionalInt minVal = countMap.values().stream().mapToInt(Integer :: new).min();
		if(minVal.isPresent()) {
			int min = minVal.getAsInt();
			OptionalInt maxVal = countMap.keySet().stream().filter(key -> {
				return countMap.get(key) == min;
			}).mapToInt(Integer :: new).max();
			System.out.println(maxVal.getAsInt());
		}else {
			System.out.println(-1);
		}
    }

    public static void find_highest_frequency(Map<String, Integer> countMap){
		OptionalInt maxVal = countMap.values().stream().mapToInt(Integer :: new).max();
		if(maxVal.isPresent()) {
			int max = maxVal.getAsInt();
			OptionalInt minVal = countMap.keySet().stream().filter(key -> {
				return countMap.get(key) == max;
			}).mapToInt(Integer :: new).min();
			System.out.println(minVal.getAsInt());
		}else {
			System.out.println(-1);
		}   
    }
}
