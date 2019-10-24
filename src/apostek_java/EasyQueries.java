package apostek_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Partially Accepted
 * @author Dell
 *
 */
public class EasyQueries {

	private static String[] inArrs = new String[0];
	private static int N;
	private static int left;
	private static int right;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");

		N = Integer.parseInt(str[0]);
		int Q = Integer.parseInt(str[1]);

		inArrs = br.readLine().split("\\s");
		String[] query = null;

		while(Q-- > 0) {
			query = br.readLine().split("\\s");

			if(query[0].equals("0")) {
				performZeroIndexOpr(Integer.parseInt(query[1]));
			}else {
				performOneIndexOpr(Integer.parseInt(query[1]));
			}
		}
	}

	private static void performZeroIndexOpr(int index) {

		left = -1;
		right = -1;

		Thread t1 = new Thread(() -> {
			for(int i=index-1; i>=0; i--) {
				if(inArrs[i].equals("1")) {
					left = i;
					break;
				}
			}				
		});

		t1.start();

		Thread t2 = new Thread(() -> {
			for(int i=index+1; i<N; i++) {
				if(inArrs[i].equals("1")) {
					right = i;
					break;
				}
			}
		});

		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(left + " " + right);
	}

	private static void performOneIndexOpr(int index) {
		inArrs[index] = "1";
	}
}
