package greedy_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree_Values {

	private static final Map<Integer, List<Integer>> NODES_MAP = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		String[] strArr = null;
		int u = 0;
		int v = 0;
		
		List<Integer> subList = null;
		
		for(int i=1; i<N; i++) {
			strArr = br.readLine().split("\\s");
			
			u = Integer.parseInt(strArr[0]);
			v = Integer.parseInt(strArr[1]);
			
			if(NODES_MAP.containsKey(u)) {
				subList = NODES_MAP.get(u);
			}else {
				subList = new ArrayList<>();
			}
			
			subList.add(v);
			NODES_MAP.put(u, subList);
		}
		
		for(int i=1; i<=N; i++) {
		
			subList = NODES_MAP.get(i);

			if(subList == null) {
				System.out.print(0);
			}else {
				List<Integer> routeVals = new ArrayList<>();

				for(Integer node : subList) {
					routeVals.add(getlongestRouteTillLeafNode(node));
				}

				if(routeVals.size() >= 2) {
					Collections.sort(routeVals, Collections.reverseOrder());
					System.out.print(routeVals.get(0) + routeVals.get(1));					
				}else {
					System.out.print(routeVals.get(0));
				}
			}
			
			if(i != N) {
				System.out.print(" ");
			}
		}
	}
	
	private static int getlongestRouteTillLeafNode(Integer node) {
		List<Integer> subList = NODES_MAP.get(node);
		
		if( subList == null) {
			return 1;
		}
		
		List<Integer> routeVal = new ArrayList<>();
		
		for(Integer val : subList) {
			routeVal.add(getlongestRouteTillLeafNode(val));
		}
			
		Collections.sort(routeVal, Collections.reverseOrder());
		return routeVal.get(0) + 1;
	}
}
