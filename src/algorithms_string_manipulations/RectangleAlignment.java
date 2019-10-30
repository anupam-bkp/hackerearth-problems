package algorithms_string_manipulations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Dell
 *
 *Submitted Successfully
 */
public class RectangleAlignment {

	public static void main(String[] args) throws IOException {
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  
		String[] lb = null;
		
		final List<Rectangle> rectList = new ArrayList<>();
		
		while(N-- > 0) {
			lb = br.readLine().split("\\s");
			rectList.add(new Rectangle(Integer.parseInt(lb[0]), Integer.parseInt(lb[1])));
		}
		
		Collections.sort(rectList);
		rectList.forEach(rect -> System.out.println(rect));
	}
	
	static class Rectangle implements Comparable<Rectangle>{
		 
		private int length;
		private int breadth;
		
		public Rectangle(int length, int breadth) {
			this.length = length;
			this.breadth = breadth;
		}

		@Override
		public int compareTo(Rectangle rect2) {
			if(this.length > rect2.length) {
				return 1;
			}else if(this.length == rect2.length){
				if(this.area() > rect2.area()) {
					return -1;
				}else {
					return 1;
				}
			}else {
				return -1;
			}
		}
		
		private long area() {
			return (long)length*(long)breadth;
		}

		@Override
		public String toString() {
			return length + " " + breadth;
		}
	}
	
}
