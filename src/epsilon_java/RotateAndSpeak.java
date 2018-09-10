package epsilon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dell
 *
 *Fully accepted
 */
public class RotateAndSpeak {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		String[] numPlate = null;
		String[] query = null;
		int Q = 0;
		int currPos = 0;
		int queriedPos = 0;
		int queriedLen = 0;
		int queriedTurn = 0;
		
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			numPlate = br.readLine().split("\\s");
			Q = Integer.parseInt(br.readLine());
			
			currPos = 0;
			
			while(Q-- > 0) {
				
				query = br.readLine().split("\\s");
				
				if(query[0].equals("1")) {
					queriedTurn = Integer.parseInt(query[1])%N;
					queriedLen = currPos + queriedTurn;
					if(queriedLen >= N) {
						queriedLen = queriedLen - N;
					}
					currPos = queriedLen;
					
				}else if(query[0].equals("2")) {
					queriedTurn = Integer.parseInt(query[1])%N;
					queriedLen = currPos - queriedTurn;
					if(queriedLen < 0) {
						queriedLen = N + queriedLen;
					}
					currPos = queriedLen;
				}else if(query[0].equals("3")){
					queriedPos = Integer.parseInt(query[1]);
					queriedLen = currPos + queriedPos;
					
					if(queriedLen >= N) {
						queriedLen = queriedLen - N;
					}
					System.out.println(numPlate[queriedLen]);
				}
			}
			
		}
		
	}
	
}
