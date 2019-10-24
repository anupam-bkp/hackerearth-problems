package september_2018_circuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HighJump {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int L = Integer.parseInt(str[2]);
		int A = Integer.parseInt(str[3]);
		
		final Map<Integer, Integer> obstacleMap = new HashMap<>();
		
		while(N-- > 0) {
			str = br.readLine().split("\\s");
			obstacleMap.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		int currPos = 0;
		
		while(currPos != L) {
			
			
			
		}
		
	}
	
	private static int getAscendPoint(int X, int Y, int A) {
		return (X + Y/A);
	}
	
	private static int getDescendPoint(int X, int Y, int A) {
		return (X + (2*Y)/A);
	}

}
