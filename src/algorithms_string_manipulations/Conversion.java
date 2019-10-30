package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Anupam
 * 
 * Accepted
 *
 */
public class Conversion {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			br.readLine().toLowerCase().chars().map(operand -> {
				if(operand >= 97 && operand <= 122) {
					operand = operand - 96;
				}
				return operand;
			}).forEachOrdered(value -> {
				if(value >= 1 && value <= 26) {
					System.out.print(value);
				}else {
					System.out.print("$");
				}
			});

			if(T > 0)
			System.out.println();
		}
	}
}
