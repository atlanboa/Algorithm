import java.util.Scanner;

public class Solution7985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int k;
		int[] tree;
		int mid, size;
		for(int t=1; t<=T; t++) {
			k = sc.nextInt();
			size = (2<<k-1)-1;
			tree = new int[size];
			
			for(int i=0; i<tree.length; i++) {
				tree[i] = sc.nextInt();
			}
			mid = tree.length/2;
			
			System.out.print("#"+t+" ");
			for(int i=1; i<=k; i++) {
				mid = printTree(tree, i, mid);
			}
			
			
		}
		
	}
	static int printTree(int[] tree, final int k, int index) {
		int ret = index/2;
		int add = (index+1)<<1;
		for(int i=0; i<Math.pow(2, k-1); i++){
			System.out.print(tree[index]+" ");
			index += add;
		}
		System.out.println();
		return ret;
	}

}
