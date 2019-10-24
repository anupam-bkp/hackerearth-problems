package septtember_2018_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dell
 *Fully Accepted
 */
public class PairRecovery {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a3a4 = br.readLine().split("\\s");
		
		int a3 = Integer.parseInt(a3a4[0]);
		int a4 = Integer.parseInt(a3a4[1]);
		
		int a2 = a4 - a3;
		int a1 = a3 - a2;

		System.out.println(a1 + " " + a2);
	}

}
