import java.util.Scanner;

public class functionCall {
	static SStack stack = new SStack(50);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String brachek;
		boolean flag;
		for(int i=0; i<2; i++) {
			brachek = sc.next();
			flag  = checkBrachek(brachek);
			System.out.println(flag);
			
		}
	}

	private static boolean checkBrachek(String brachek) {
		// TODO Auto-generated method stub
		char temp;
		for(int i=0; i<brachek.length();i++) {
			temp = brachek.charAt(i);
			if(temp == ')') {
				while(stack.pop()!='(');
			}else {
				stack.push(temp);
			}
		}
		return stack.isEmpty()?true:false;
	}

}
