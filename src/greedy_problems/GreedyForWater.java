package greedy_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @author Dell
 *
 *Accepted
 */
public class GreedyForWater {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int X = 0;		
		int maxNumOfBottle = 0;
		
		while(T-- > 0) {
			
			maxNumOfBottle = 0;
			
			X = Integer.parseInt(br.readLine().split("\\s")[1]);
			
			List<Integer> bottles = Stream.of(br.readLine().split("\\s"))
					.mapToInt(Integer :: parseInt).sorted()
					.collect(ArrayList :: new, List :: add, (t, u) -> {});
			
			for(Integer bottle : bottles) {
				X -= bottle;
				if(X >= 0) {
					maxNumOfBottle++;
				}else {
					break;
				}
			}
			
			System.out.println(maxNumOfBottle);
		}
		
	}
	
}
