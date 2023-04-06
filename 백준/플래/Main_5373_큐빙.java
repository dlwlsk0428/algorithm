import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {

	public static char cube[][][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cube = new char[6][3][3];
		
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++) {
			reset();
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int num = st.countTokens();
			for(int tu = 0; tu < num; tu++) {
				String s = st.nextToken();
				//System.out.println("==========="+tu+s+"=============");
				getTurn(s.charAt(0), s.charAt(1));
			}
			print();
		}

		
	}
	public static void reset() {
		char color[] = new char[] {'w', 'g', 'r', 'o', 'b', 'y'};
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<3; j++) {
				for(int k = 0; k<3; k++) {
					cube[i][j][k] = color[i];
				}
			}
		}
	}
	
	public static void getTurn(char c, char mp) {
		if(c == 'U') {
			if(mp == '-') turn(0, mp, 1, 2, 4, 3);
			else turn(0, mp, 3, 4, 2, 1);
		}
		else if(c == 'L') {
			if(mp == '-') turn(1, mp, 2, 0, 3, 5);
			else turn(1, mp, 5, 3, 0, 2);
		}
		else if(c == 'F') {
			if(mp == '-') turn(2, mp, 0, 1, 5, 4);
			else turn(2, mp, 4, 5, 1, 0);
		}
		else if(c == 'B') {
			if(mp == '-') turn(3, mp, 4, 5, 1, 0);
			else turn(3, mp, 0, 1, 5, 4);
		}
		else if(c == 'R') {
			if(mp == '-') turn(4, mp, 5, 3, 0, 2);
			else turn(4, mp, 2, 0, 3, 5);
		}
		else {
			if(mp == '-') turn(5, mp, 3, 4, 2, 1);
			else turn(5, mp, 1, 2, 4, 3);
		}
	}
	
	public static void turn(int dir, char mp, int a, int b, int c, int d) {
		char newCube[][][] = new char[6][3][3];
		boolean check[][][] = new boolean[6][3][3];
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(mp == '-') {
					newCube[dir][2-j][i] = cube[dir][i][j];
				} else if(mp == '+') {
					newCube[dir][j][2-i] = cube[dir][i][j];
				}
				check[dir][i][j] = true;
			}
		}
		
		for(int i = 0; i<6; i++) {
			if(i == dir || i == (5-dir)) continue;
			int n;
			if(i == a) n = b;
			else if(i == b) n = c;
			else if(i == c) n = d;
			else n = a;
			for(int j = 0; j<3; j++) {
				if(dir == 0) { // U0
					newCube[n][0][j] = cube[i][0][j];
					check[n][0][j] = true;
				}
				else if(dir == 1) { // L0
					if(n == 3) {
						newCube[n][2-j][2] = cube[i][j][0];
						check[i][j][0] = true;
					}
					else if(i == 3) {
						newCube[n][j][0] = cube[i][2-j][2];
						check[i][2-j][2] = true;
					}
					else {
						newCube[n][j][0] = cube[i][j][0];
						check[i][j][0] = true;
					}
				}
				else if(dir == 2) { // F0
					if(i == 0) {
						if(mp == '-') newCube[n][2-j][2] = cube[i][2][j];
						else newCube[n][j][0] = cube[i][2][j];
						check[i][2][j]= true;
					}
					else if(i == 1) {
						if(mp == '-') newCube[n][0][j] = cube[i][j][2];
						else newCube[n][2][2-j] = cube[i][j][2];
						check[i][j][2] = true;
					}
					else if (i == 5) {
						if(mp == '-') newCube[n][2-j][0] = cube[i][0][j];
						else newCube[n][j][2] = cube[i][0][j];
						check[i][0][j]= true;
					}
					else if (i == 4) {
						if(mp == '-') newCube[n][2][j] = cube[i][j][0];
						else newCube[n][0][2-j] = cube[i][j][0];
						check[i][j][0]= true;
					}	
				}
				else if(dir == 5) { // D
					newCube[n][2][j] = cube[i][2][j];
					check[n][2][j] = true;
				}
				else if(dir == 4) { // R
					if(n == 3) {
						newCube[n][2-j][0] = cube[i][j][2];
						check[i][j][2] = true;
					}
					else if(i == 3) {
						newCube[n][j][2] = cube[i][2-j][0];
						check[i][2-j][0] = true;
					}
					else {
						newCube[n][j][2] = cube[i][j][2];
						check[i][j][2] = true;
					}
				}
				else if(dir == 3) { // B
					if(i == 5) {
						if(mp == '-') newCube[n][j][0] = cube[i][2][j];
						else newCube[n][2-j][2] = cube[i][2][j];
						check[i][2][j]= true;
					}
					else if(i == 4) {
						if(mp == '-') newCube[n][2][2-j] = cube[i][j][2];
						else newCube[n][0][j] = cube[i][j][2];
						check[i][j][2] = true;
					}
					else if (i == 0) {
						if(mp == '-') newCube[n][j][2] = cube[i][0][j];
						else newCube[n][2-j][0] = cube[i][0][j];
						check[i][0][j]= true;
					}
					else if (i == 1) {
						if(mp == '-') newCube[n][0][2-j] = cube[i][j][0];
						else newCube[n][2][j] = cube[i][j][0];
						check[i][j][0]= true;
					}
				}
			}
		}
		
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<3; j++) {
				for(int k = 0; k<3; k++) {
					if(check[i][j][k]) cube[i][j][k] = newCube[i][j][k];
				}
			}
		}
		//print();
	}
	
	public static void print() {
				
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				System.out.print(cube[0][i][j]);
			}
			System.out.println();
		}
	}
}
