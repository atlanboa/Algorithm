import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {
	/*
	 * S : Shoot U : up D : down L : left R : right
	 */
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int h, w, x, y;
			char dir;
			x = -1;
			y = -1;
			dir = '\u0000';
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						dir = map[i][j];
						x = i;
						y = j;
					}
				}
			}

			int cmdLength = Integer.parseInt(br.readLine());
			char[] cmd = br.readLine().toCharArray();

			play(cmd, x, y, dir);

			System.out.print("#" + t + " ");
			for (int i = 0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}

	private static void play(char[] cmd, int x, int y, char dir) {
		int dx, dy, nx, ny;

		for (int i = 0; i < cmd.length; i++) {
			
			

			dx = 0;
			dy = 0;
			switch (cmd[i]) {
			case 'S':
				shoot(x, y, dir);
				continue;
			case 'U':
				dx = -1;
				dy = 0;
				dir = '^';
				break;
			case 'D':
				dx = 1;
				dy = 0;
				dir = 'v';
				break;
			case 'L':
				dx = 0;
				dy = -1;
				dir = '<';
				break;
			case 'R':
				dx = 0;
				dy = 1;
				dir = '>';
				break;
			}
			nx = x + dx;
			ny = y + dy;
			if(0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {

				if(map[nx][ny]=='.') {
					map[x][y]='.';
					map[nx][ny]=dir;	
					x = nx;
					y = ny;
				}else {
					map[x][y]=dir;
				}

				

			}else {
				map[x][y]=dir;
			}

		}

	}

	private static void shoot(int x, int y, char dir) {
		int dx, dy;
		dx = 0;
		dy = 0;
		switch (dir) {
		case '<':
			
			dy = -1;
			break;
		case '>':

			dy = 1;
			break;
		case '^':
			dx = -1;
			
			break;
		case 'v':
			dx = 1;
			
			break;
		}
		int nx, ny;
		nx = x + dx;
		ny = y + dy;
		while (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
			if(map[nx][ny]=='#') break;
			
			nx += dx;
			ny += dy;
			
		}

	}

}
