package algorithms_string_manipulations;

import java.math.BigInteger;

public class Test {

	public static void main(String args[]) {
		
		String str = "111111111111111000000000000000011111111";
		System.out.println(Long.parseLong(str, 2)%1000000007);
		
		String str1 = "1111111111111111111111111111111111111111111111111111111111111111";
		System.out.println(str1.length());
		System.out.println(getDecVal(str1));
		
	}
	
	private static long getDecVal(String binVal) {
		
		BigInteger bin = new BigInteger(binVal, 2);
		BigInteger mod = bin.mod(new BigInteger("1000000007"));
		
		return mod.longValue();
		
	}
	
	
	
	
}
