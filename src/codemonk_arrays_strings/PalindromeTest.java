package codemonk_arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted
public class PalindromeTest {
	
	private static final String PALINDROME_YES = "YES";
	private static final String PALINDROME_NO = "NO";
	private static final String PALINDROME_EVEN = "EVEN";
	private static final String PALINDROME_ODD = "ODD";
	private static final String SPACE  = " ";
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int T = Integer.parseInt(br.readLine());

		String text = "";
		String even_Or_Odd = "";
		boolean isPalindrome = false;
		
		int len = 0;
		int mid = 0;
	
		for(int i=0; i<T; i++) {
			text = br.readLine();
			len = text.length();
			
			if(len == 1) {
				System.out.println(PALINDROME_YES + SPACE + PALINDROME_ODD);
			}else if(len == 2) {
				if(text.charAt(0) == text.charAt(1)) {
					System.out.println(PALINDROME_YES + SPACE + PALINDROME_EVEN);
				}else {
					System.out.println(PALINDROME_NO);
				}
			}else {		
				
				if(len%2 == 0) {
					even_Or_Odd = PALINDROME_EVEN;
					mid = len/2;
				}else {
					even_Or_Odd = PALINDROME_ODD;
					mid = len/2 + 1;
				}
				
				isPalindrome = true;
				
				for(int start=0,end=len-1; start<mid; start++,end--) {
					if(!(text.charAt(start) == text.charAt(end))) {
						isPalindrome = false;
						break;
					}
				}
				
				if(isPalindrome) {
					System.out.println(PALINDROME_YES + SPACE + even_Or_Odd);
				}else {
					System.out.println(PALINDROME_NO);
				}
						 
			}
		}	
	}
}
