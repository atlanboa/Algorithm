package SW아카데미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()); 
			int n; String dir;
			n = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			
			int[][] tile = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					tile[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
			
			switch (dir) {
			case "up":
				for(int j=0; j<n; j++) {
					for(int i=0; i<n-1; i++) {
						int idx = 0;
						if(tile[i][j]==0) {
							idx = i+1;
							while(idx < n) {
								if(tile[idx][j]!=0) {
									tile[i][j] = tile[idx][j];
									tile[idx][j] = 0;
									i--;
									break;
								}
								idx++;
							}
						}else {
							idx = i+1;
							while(idx < n) {
								if(tile[idx][j]==0) {
									idx++;
								}else {
									if(tile[idx][j]==tile[i][j]) {
										
										tile[i][j] += tile[idx][j];
										tile[idx][j] = 0;
										
									}
									break;
								}
							}
						}
						
					}
				}
				
				break;
			case "down":
				for(int j=0; j<n; j++) {
					for(int i=n-1; i>0; i--) {
						int idx = 0;
						if(tile[i][j]==0) {
							idx = i-1;
							while(idx >= 0) {
								if(tile[idx][j]!=0) {
									tile[i][j] = tile[idx][j];
									tile[idx][j] = 0;
									i++;
									break;
								}
								idx--;
							}
						}else {
							idx = i-1;
							while(idx >= 0) {
								if(tile[idx][j]==0) {
									idx--;
								}else {
									if(tile[idx][j]==tile[i][j]) {
										
										tile[i][j] += tile[idx][j];
										tile[idx][j] = 0;
										
									}
									break;
								}
							}
						}
						
					}
				}
				break;
			case "left":
				for(int i=0; i<n; i++) {
					for(int j=0; j<n-1; j++) {
						int idx = 0;
						if(tile[i][j]==0) {
							idx = j+1;
							while(idx < n) {
								if(tile[i][idx]!=0) {
									tile[i][j] = tile[i][idx];
									tile[i][idx] = 0;
									j--;
									break;
								}
								idx++;
							}
						}else {
							idx = j+1;
							while(idx < n) {
								if(tile[i][idx]==0) {
									idx++;
								}else {
									if(tile[i][idx]==tile[i][j]) {
										
										tile[i][j] += tile[i][idx];
										tile[i][idx] = 0;
										
									}
									break;
								}
							}
						}
						
					}
				}
				break;
			case "right":
				for(int i=0; i<n; i++) {
					for(int j=n-1; j>0; j--) {
						int idx = 0;
						if(tile[i][j]==0) {
							idx = j-1;
							while(idx >= 0) {
								if(tile[i][idx]!=0) {
									tile[i][j] = tile[i][idx];
									tile[i][idx] = 0;
									j++;
									break;
								}
								idx--;
							}
						}else {
							idx = j-1;
							while(idx >= 0) {
								if(tile[i][idx]==0) {
									idx--;
								}else {
									if(tile[i][idx]==tile[i][j]) {
										
										tile[i][j] += tile[i][idx];
										tile[i][idx] = 0;
										
									}
									break;
								}
							}
						}
						
					}
				}
				break;
			}
			
			System.out.println("#"+t);
			for(int i=0; i<n;i++) {
				for(int j=0; j<n; j++) {
					System.out.print(tile[i][j]+" ");
				}
				System.out.println();
			}
			
		}

	}
}
