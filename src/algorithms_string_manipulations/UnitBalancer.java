package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnitBalancer {

	public static void main(String[] args) throws IOException {
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final String[] units = br.readLine().split(",");
		final List<String[]> equations = new ArrayList<>();
		
		final StringBuilder sb = new StringBuilder();
		BigInteger currMul = new BigInteger("1");
		
		for(int i=0; i<units.length-1; i++) {
			equations.add(br.readLine().split("\\s"));
		}
		
		String biggestUnit = "";
		
		//Finding biggest unit
		for(String unit : units) {
			
			Optional<String[]> findFirst = equations.stream().filter(equation -> {
				return equation[3].equals(unit);
			}).findFirst();
			
			if(!findFirst.isPresent()) {
				biggestUnit = unit;
				sb.append("1"+unit);
				break;
			}
		}
		
		for(int i=0; i<units.length; i++) {
			
			final String currentUnit = biggestUnit;
			Optional<String[]> findFirst = equations.stream().filter(equation -> {
				return equation[0].equals(currentUnit);
			}).findFirst();
			
			if(findFirst.isPresent()) {
				String[] eqParts = findFirst.get();
				currMul = currMul.multiply(new BigInteger(eqParts[2]));
			    biggestUnit = eqParts[3];
				sb.append(" = " + currMul + biggestUnit);
			}
		}
	
		System.out.println(sb.toString());
	}
	
}
