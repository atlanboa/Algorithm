package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static final int MAX_NUM = 1000000000;
	static Stack<Long> stack;
	static ArrayList<String> cmd;
	static Long[] numbers;
	public static void main(String[] args) throws Exception{
		
		stack = new Stack<Long>();
		cmd = new ArrayList<String>();
		int n;
		while(true) {
			
			//명령어 입력받다가 end 받으면 숫자를 받습니다. n개 만큼
			
			String command = br.readLine();
			if(command.contains("QUIT")) {
				break;
			}
			else if(command.contains("END")) {
				cmd.add(command);
				
				n = Integer.parseInt(br.readLine());
				numbers = new Long[n];
				
				for(int i=0; i<n; i++) {
					numbers[i] = Long.parseLong(br.readLine());
				}
				
				for(int i=0; i<n; i++) {
					
					//숫자 넣고 시작하고
					stack.clear();
					stack.add(numbers[i]);
					boolean flag = true;
					for(int j=0; j<cmd.size(); j++) {
						String curCmd = cmd.get(j);
						
						
						if(curCmd.equals("POP")) {
							flag = pop();
						}else if(curCmd.equals("INV")) {
							flag = inv();
						}else if(curCmd.equals("SWP")) {
							flag = swp();
						}else if(curCmd.equals("ADD")) {
							flag = add();
						}else if(curCmd.equals("SUB")) {
							flag = sub();
						}else if(curCmd.equals("MUL")) {
							flag = mul();
						}else if(curCmd.equals("DIV")) {
							flag = div();
						}else if(curCmd.equals("MOD")) {
							flag = mod();
						}else if(curCmd.equals("DUP")) {
							flag = dup();
						}
						else if(curCmd.length() >= 4) {
							num(Long.parseLong(curCmd.split(" ")[1]));
						}
						
						if(!flag) {
							break;
						}
						
						
					}
					
					if(!flag || stack.size() != 1) System.out.println("ERROR");
					else if(flag) System.out.println(stack.peek());
					
					
					
				}
				System.out.println();
				cmd.clear();
				br.readLine();
				
				
				
			}else {
				cmd.add(command);
			}
			
			
			
		}
	}
	
	public static void num(Long number) {
		stack.add(number);
	}
	
	public static boolean pop() {
		if(stack.isEmpty()) return false;
		stack.pop();
		return true;
	}
	public static boolean dup() {
		if(stack.isEmpty()) return false;
		stack.push(stack.peek());
		return true;
	}
	
	public static boolean inv() {
		if(stack.isEmpty()) return false;
		Long number = stack.pop();
		stack.push(number*-1);
		return true;
	}
	public static boolean swp() {
		if(stack.size() < 2) return false;
		Long number1, number2;
		number1 = stack.pop();
		number2 = stack.pop();
		
		stack.push(number1);
		stack.push(number2);
		return true;
	}
	//숫자가 부족해서 연산을 수행할 수 없을 때, 0으로 나눴을 때 (DIV, MOD), 연산 결과의 절댓값이 109를 넘어갈 때는 모두 프로그램 에러이다.
	public static boolean add(){
			if(stack.size() < 2) return false;
			
			Long number = stack.pop()+stack.pop();
			stack.push(number);
			
			return Math.abs(number)>MAX_NUM?false:true;

	}
	
	public static boolean sub() {
		if(stack.size() < 2) return false;
		Long number1, number2, number;
		number1 = stack.pop();
		number2 = stack.pop();
		number = number2-number1;
		stack.push(number);
		return Math.abs(number)>MAX_NUM?false:true;
	}
	public static boolean mul() {
		if(stack.size() < 2) return false;
		Long number1, number2, number;
		number1 = stack.pop();
		number2 = stack.pop();
		number = number1 * number2;
		stack.push(number);
		return Math.abs(number)>MAX_NUM?false:true;
	}
	public static boolean div() {
		if(stack.size() < 2) return false;
		Long number1, number2, number;
		number1 = stack.pop();
		number2 = stack.pop();
		if(number1 == 0) return false;
		

		
		number = number2/number1;
//		System.out.println(number2+" "+number1);
		//마이너스가 1개인 경우만 음수
		
		stack.push(number);
		return Math.abs(number)>MAX_NUM?false:true;
		
	}
	public static boolean mod() {
		if(stack.size() < 2) return false;
		Long number1, number2, number;
		number1 = stack.pop();
		number2 = stack.pop();
		if(number1 == 0) return false;
//		System.out.println("숫자 출력 :: "+number1+" "+number2);
		
		number = number2%number1;
		
		stack.push(number);
		return Math.abs(number)>MAX_NUM?false:true;
		
	}
	/*
	 INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
	 */
}
