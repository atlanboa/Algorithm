package day2;

import java.util.Scanner;

public class Frequency {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] score;
		int t = sc.nextInt();
		int tCaseNum;
		for(int i = 0; i<t; i++) {
			tCaseNum = sc.nextInt();
			score = new int[101];
			for(int j=0; j<1000; j++) {
				score[sc.nextInt()]++;
			}
			System.out.println("#"+tCaseNum+" "+getScore(score));
		}
		
		
	}
	
	public static int getScore(int[] score) {
		int max = 0;
		int index = 0;
		for(int i = 0; i<score.length; i++) {
			if(score[i] >= max) {				
				max = score[i];
				index = i;
			}
		}
		
		
		return index;
	}

}
