package day2;
//알고리즘 1주차 연습문제 1번
//주어진 데이터에서 상자의 최대 낙차를 구하라
public class Practice1 {

//	samples = {2, 7, 0, 0, 0, 0, 0, 0, 0} {7, 4, 2, 0, 0, 6, 0, 7, 0}
	static int[] data = {2, 7, 0, 0, 0, 0, 0, 0, 0};
	static int row = 8;
	static int col = 9;
	static int[][] arr = new int[row][col];
	static int[][] rotatedArr = new int[col][row];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildData();
		rotateArr();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				System.out.print(rotatedArr[i][j]+ " ");
			}
			System.out.println();
		}
		
		System.out.println(findMaxDrop());
		
		System.out.println(findMaxDrop2());

	}
	
	
	public static void buildData() {
		for(int i = 0; i<col; i++) {
			int rep = (row-data[i]-1);
			for(int j = row-1; j>rep; j--) {
				
				arr[j][i] = 1;
				
			}
		}
	}
	
	public static void rotateArr() {
		for(int i=0; i<col; i++) {
			for(int j =0; j<row; j++) {
				rotatedArr[i][j] = arr[row-j-1][i];
			}
		}
	}
	
	public static int findMaxDrop() {
		int max = 0;
		int temp;
		for(int i=0; i<row; i++) {
			temp = 0;
			for(int j=0; j<col; j++) {
				if(rotatedArr[j][i] == 0) {
					temp ++;	
				}
			}
			if(temp > max && rotatedArr[0][i] == 1) {
				max = temp;
			}
		}
		
		
		
		return max;
		
	}
	
	public static int findMaxDrop2() {
		int max = 0;
		int temp;
		for(int i = 0; i<data.length; i++) {
			temp = 0;
			for(int j = i+1; j<data.length; j++) {
				if(data[i] > data[j]) {
					temp++;
				}
			}
			if(temp > max) {
				max = temp;
			}
			
		}
		return max;
		
	}

}
