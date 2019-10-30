package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeEqualParts {

	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N = 0;
		String[] strArr = null;
		String str = "";
		long val1 = 0l; long val2 = 0; long val3 = 0l;

		while(T-- > 0) {

			N = Integer.parseInt(br.readLine());
			strArr = br.readLine().split("\\s");
			str = Stream.of(strArr).collect(Collectors.joining());

			System.out.println(str);

			boolean result = false;
			
			String str1 = "";
			String str2 = "";
			String str3 = "";
			
			for(int i=0; i<N-2; i++) {
				str1 = str.substring(0, i+1);
				val1 = getDec(str1);
//				System.out.println("Val1 : " + val1);

				for(int k=i+1; k<N-1; k++) {
					str2 = str.substring(i+1, k+1);
					val2 = getDec(str2);
					str3 = str.substring(k+1);
					val3 = getDec(str3);

//					System.out.println(str1 + " :: " + str2 + " :: " + str3);
//					System.out.println(val1 + " :: " + val2 + " :: " + val3);
					
					if(val1 == val2 && val1 == val3 && val2 == val3) {
						result = true;
						break;
					}
				}
				
				if(result) {
					break;
				}
				
//				System.out.println("=======================");
			}

			if(result) {
				System.out.println(val1);
			}else {
				System.out.println(-1);
			}

		}

	}

	/*private static long getDec(String str) {
		return Long.parseLong(str, 2)%1000000007;
	}*/
	
	private static long getDec(String binVal) {
		
		BigInteger bin = new BigInteger(binVal, 2);
		BigInteger mod = bin.mod(new BigInteger("1000000007"));
		
		return mod.longValue();
	}

}
