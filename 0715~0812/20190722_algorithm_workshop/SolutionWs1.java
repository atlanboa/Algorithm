import java.util.Scanner;

public class SolutionWs1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] str = new String[5];
		
		for(int t=1; t<=T; t++) {
			for(int i=0; i<5; i++){
				
				str[i] = sc.next().toString();
				
			}
			
			int index = 0;
			String output = "";
			while(true) {
				if(str[0].length() <= index && 
						str[1].length() <= index &&
						str[2].length() <= index &&
						str[3].length() <= index &&
						str[4].length() <= index
						) {
					
					break;
					
				}
				else {
					try {
						output += str[0].charAt(index);
					}catch(IndexOutOfBoundsException e) {
						
					}try {
						output += str[1].charAt(index);
					}catch(IndexOutOfBoundsException e) {
						
					}try {
						output += str[2].charAt(index);
					}catch(IndexOutOfBoundsException e) {
						
					}try {
						output += str[3].charAt(index);
					}catch(IndexOutOfBoundsException e) {
						
					}try {
						output += str[4].charAt(index);
					}catch(IndexOutOfBoundsException e) {
						
					}
					index++;
					

				}
			}
			System.out.println("#"+t+" "+output);
		}
		
	
		
	}

}
