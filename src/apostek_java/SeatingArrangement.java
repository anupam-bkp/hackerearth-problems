package apostek_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Partially Accepted
 * @author Dell
 *
 */
public class SeatingArrangement {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split("\\s");

		BigInteger numOfChairs = new BigInteger(br.readLine());		
		int numOfPersons = Integer.parseInt(inArr[1]);
		String choices = "a"+br.readLine();
		
		Map<BigInteger, Integer> positionMap = new HashMap<>();
		
		if(numOfChairs.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0) {
			BigInteger divide = numOfChairs.divide(new BigInteger("2"));
			if(choices.charAt(1) == 'L') {
				divide = divide.add(BigInteger.ONE);
			}
			positionMap.put(divide, 1);
		}else {
			positionMap.put(numOfChairs.divide(new BigInteger("2")), 1);
		}
		
		for(int i=2; i<=numOfPersons; i++) {
	
			
			
		}
		
		
	}
	
}