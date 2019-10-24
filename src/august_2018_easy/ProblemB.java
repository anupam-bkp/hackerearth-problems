package august_2018_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pikachu vs Team Meowstic and Helping Hand
 * 
 * @author Dell
 *
 */
public class ProblemB {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		
		Object[] powers = Stream.of(br.readLine().split("\\s")).map(BigInteger :: new).toArray();
			
		BigInteger curr = null;
		BigInteger prev = null;
		
		while(k-- > 0) {
			for(int i=1; i<n; i++) {
				curr = (BigInteger)powers[i];
				prev = (BigInteger)powers[i-1];
				powers[i] = curr.or(prev);
			}
		}
	
		String result = Stream.of(powers).map(power -> ((BigInteger)power).toString()).collect(Collectors.joining(" "));
		System.out.println(result);	
	}
}
