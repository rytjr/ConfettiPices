package ConfettiPices;

import java.util.*;
import java.io.*;

public class ConfettiPices {
	
	static int[][] arr;
	static int zero = 0;
	static int one = 0;
	static int minuse = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int Num = Integer.parseInt(st.nextToken());
		
		arr = new int[Num][Num];
		
		for(int i = 0; i < Num; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j< Num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		recur(0, 0, Num);
		
		System.out.println(minuse);
		System.out.println(zero);
		System.out.println(one);
		
	}
	
	public static void recur(int left, int right, int N) {
		
		if(check(left, right, N)) {
			if(arr[left][right] == 0) {
				zero++;
			}
			else if(arr[left][right] == 1) {
				one++;
			}
			else {
				minuse++;
			}
			return;
		}
		
		int size = N /3;
		int size2 = size * 2;
		recur(left, right, size);
		recur(left, right + size, size);
		recur(left, right + size2, size);
		recur(left + size, right, size);
		recur(left + size, right + size, size);
		recur(left + size, right + size2, size);
		recur(left + size2, right, size);
		recur(left + size2, right + size, size);
		recur(left + size2, right + size2, size);
		
	}
	
	public static boolean check(int left, int right, int N) {
		
		int no = arr[left][right];
		
		for(int i = left; i < N + left; i++) {
			for(int j = right; j < N + right; j++) {
				if(no != arr[i][j]) return false;
			}
		}
		return true;
	}

}
