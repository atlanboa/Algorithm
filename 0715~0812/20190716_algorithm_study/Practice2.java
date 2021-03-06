package day2;

import java.util.Arrays;



//조건문이나 혹은 try catch 문을 사용하지 않고 배열을 경계 한칸을 더 넓게 사용하면
//불필요한 조건문이 많이 사라짐

public class Practice2 {
//	5 by 5 배열의 경계범위
	static int[][] arr = new int[5][5];
//	5 by 5 배열의 경계범위를 한칸 더 넓게 사용하는 경우
	static int[][] arr2 = new  int[7][7];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setData();
		for(int[] temp:arr2) {
			System.out.println(Arrays.toString(temp));
		}
		System.out.println(Arrays.toString(getMaxValueAndPoint()));
//		System.out.println(sumSub1());
//		System.out.println(sumSub2());
//		System.out.println(sumSub3());
//		System.out.println(sumSub4());
	}
	
	public static void setData() {
		for(int i=1; i<arr2.length-1; i++) {
			for(int j=1; j<arr2.length-1; j++) {
				arr2[i][j] = (int)(Math.random()*25)+1;
			}
		}
	}
	
	public static int[] getMaxValueAndPoint() {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		int x = -1;
		int y = -1;
		int max = 0;
		int sum = 0;
		
		for(int i=1; i<arr2.length-1; i++) {
			for(int j=1; j<arr2.length-1; j++) {
				sum = 0;
				for(int r=0; r<dx.length; r++) {
					sum += arr2[i+dy[r]][j+dx[r]];
				}
				if(sum > max) {
					max = sum;
					y = j;
					x = i;
				}
			}
		}
		int[] reArr = {x, y, max};
		
		return reArr;
		
	}
	
	
//	public static void setData() {
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				arr[i][j] = (int)(Math.random()*25)+1;
//			}
//		}
//	}
////	행 우선 순회
//	public static int sumSub1() {
//		int sum=0;
//		
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				
//				try {
//					sum += Math.abs(arr[i][j]-arr[i][j-1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i][j+1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i-1][j]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i+1][j]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				
//				
//						
//				
//			}
//		}
//		return sum;
//	}
//	
////	열 우선 순회
//	public static int sumSub2() {
//		int sum=0;
//		
//		for(int j=0; j<arr.length; j++) {
//			for(int i=0; i<arr[j].length; i++) {
//				
//				try {
//					sum += Math.abs(arr[i][j]-arr[i][j-1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i][j+1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i-1][j]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j]-arr[i+1][j]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//						
//				
//			}
//		}
//		return sum;
//	}
////	지그재그 순회
//	public static int sumSub3() {
//		int sum=0;
//		
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				
//				try {
//					sum += Math.abs(arr[i][j+ (arr[i].length-1-2*j)*(i%2)]-arr[i][j + (arr[i].length-1-2*j)*(i%2)-1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j + (arr[i].length-1-2*j)*(i%2)]-arr[i][j + (arr[i].length-1-2*j)*(i%2)+1]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j + (arr[i].length-1-2*j)*(i%2)]-arr[i-1][j + (arr[i].length-1-2*j)*(i%2)]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//				try {
//					sum += Math.abs(arr[i][j + (arr[i].length-1-2*j)*(i%2)]-arr[i+1][j + (arr[i].length-1-2*j)*(i%2)]);
//				}catch(IndexOutOfBoundsException e) {
//					
//				}
//						
//				
//			}
//		}
//		return sum;
//	}
//	
////	델타를 이용한 2차원 배열 탐색
//	public static int sumSub4() {
//		int sum=0;
//		int x;
//		int y;
//		// 상하좌우
//		int[] dx = {0, 0, -1, 1};
//		int[] dy = {-1, 1, 0, 0};
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				for(int o=0; o<4; o++) {
//					x = i + dx[o];
//					y = j + dy[o];
//					sum += getSubValue(arr, arr[i][j], x, y);
//				}
//				
//						
//				
//			}
//		}
//		return sum;
//	}
//	
//	public static int getSubValue(int[][] arr, int A, int x, int y) {
//		
//		try {
//			return Math.abs(A-arr[x][y]);
//		}catch(IndexOutOfBoundsException e) {
//			return 0;
//		}
//		
//	}
	
}
