package excelfore_java_hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Partially Accepted
 * @author Dell
 *
 */
public class ChallengingTrack {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input = null;
		long N = 0;
		long P = 0;
		int count = 1;
		int currHt = 0;
		
		int[] htArr = null;
		
		while(T-- > 0){
			input = br.readLine().split("\\s");
			
			N = Long.parseLong(input[0]);
			P = Long.parseLong(input[1]);
			
			htArr = Stream.of("0 ".concat(br.readLine()).split("\\s")).mapToInt(Integer :: parseInt).toArray();
			
			count = 1;
			
//			System.out.println("Count : " + count + " :: Power : " + P);
//			System.out.println("InputArr : " + Arrays.toString(htArr));
			
			if(P > 0) {
				P -= htArr[count];
			}
			
			while(count < N) {
				
//				System.out.println("=====================================");
				
				count++;
//				System.out.println("Count : " + count + " :: Power : " + P);
				
				if(count%2 == 0) {
					for(int i=count; i<=N; i++) {
						if(htArr[i]%2 == 0) {
							htArr[i] -= 1;
						}
					}
				}else {
					for(int i=count; i<=N; i++) {
						if(htArr[i]%2 != 0) {
							htArr[i] -= 1;
						}
					}
				}
				
//				System.out.println("Current Array : " + Arrays.toString(htArr));
				
				currHt = htArr[count];
				if(currHt <= 0 ) continue;
				
				P -= currHt;	
			}
			
			if(P >= 0) {
				System.out.println("Yes " + P);
			}else {
				System.out.println("No");
			}
		}
	}
	
}

