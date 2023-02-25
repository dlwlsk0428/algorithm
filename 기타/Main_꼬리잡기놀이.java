import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_꼬리잡기놀이 {

	public static class Team {
		List<int[]> list;
		
		Team(){
			this.list = new ArrayList<>();
		}
	}
	public static int n, m, k;
	public static int map[][];
	public static int place[][];
	public static Team team[];
	public static int dir[][] = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		team = new Team[m];
		for(int i = 0; i<m; i++) team[i] = new Team();
		int idx = 0;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) team[idx++].list.add(new int[] {i, j, 1});
			}
		}
		
		int score = 0;
		findTeam();
//		System.out.println("0: " + team[0].list.size());
//		System.out.println("1: " + team[1].list.size());
//		System.out.println("2: " + team[2].list.size());
//		System.out.println(team[2].list.get(0)[0] + ", " + team[2].list.get(0)[1] + " " + team[2].list.get(0)[2]);
//		System.out.println(team[2].list.get(1)[0] + ", " + team[2].list.get(1)[1] + " " + team[2].list.get(1)[2]);
		for(int i = 0; i<k; i++) {
			move();
			score += getScore(i);
			print();
			System.out.println(score);
		}
		
		System.out.println(score);
	}
	
	public static void print() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean inRange(int x, int y) {
		if(x >= 0 && x < n && y>= 0 && y < n) return true;
		return false;
	}
	
	public static void findTeam() {
		boolean visited[][] = new boolean[n][n];
		for(Team t : team) {
			boolean finish = true;
			int x = t.list.get(0)[0], y = t.list.get(0)[1];
			while(finish) {
				for(int d = 0; d < dir.length; d++) {
					int fx = x + dir[d][0], fy = y + dir[d][1];
					if(inRange(fx, fy) && !visited[fx][fy]) {
						if(map[fx][fy] == 2) {
							t.list.add(new int[] {fx, fy, 2});
							visited[fx][fy]=true;
							x = fx; y = fy;
							break;
						} 
					}
				}
				for(int d = 0; d < dir.length; d++) {
					int fx = x + dir[d][0], fy = y + dir[d][1];
					if(inRange(fx, fy) && !visited[fx][fy]) {
						if(map[fx][fy] == 3) {
							t.list.add(new int[] {fx, fy, 3});
							finish = false;
							x = fx; y = fy;
							break;
						}
					}
				}
			}
		}
	}
	
	public static void move() {
		for(Team t : team) {
			for(int d = 0; d < dir.length; d++) {
				int x = t.list.get(0)[0] + dir[d][0], y = t.list.get(0)[1] + dir[d][1];
				if(inRange(x, y) && map[x][y] > 2) {
					int tmp[] = t.list.remove(t.list.size() - 1);
					if(map[x][y] == 4) map[tmp[0]][tmp[1]] = 4;
					t.list.get(0)[2] = 2;
					t.list.get(t.list.size() - 1)[2] = 3;
					t.list.add(0, new int[] {x, y, 1});
					
					for(int [] human: t.list) {
						map[human[0]][human[1]] = human[2];
					}
					break;
				}
			}
		}
	}
	
	public static int getScore(int turn) {
		int score = 0;
		int d = (turn / n) % 4; 
		int idx = d < 2 ? turn % n : n - 1 - turn%n;
//		System.out.println(turn + ": " +d + " " + idx);
		
		if(d == 0) {
			for(int i = 0; i<n; i++) {
				if(map[idx][i] > 0 && map[idx][i] < 4) {
					int getBall = 0;
					for(Team t : team) {
						if(getBall > 0) break;
						for(int j = 0; j<t.list.size(); j++) {
							if(t.list.get(j)[0] == idx && t.list.get(j)[1] == i) {
//								System.out.println(idx + ", " + i);
								getBall = j + 1;
								Collections.reverse(t.list);
//								System.out.println(">>>" + t.list.get(0)[0] + " " + t.list.get(0)[1]);
								t.list.get(0)[2] = 1;
								t.list.get(t.list.size()-1)[2] = 3;
								break;
							}
						}
					}
//					System.out.println(getBall);
					score += Math.pow(getBall, 2);
					break;
				}
			}
		}
		else if(d == 1) {
			for(int i = n-1; i>=0; i--) {
//				System.out.println(i + " : " + idx);
				if(map[i][idx] > 0 && map[i][idx] < 4) {
					int getBall = 0;
					for(Team t : team) {
						if(getBall > 0) break;
						for(int j = 0; j<t.list.size(); j++) {
							if(t.list.get(j)[0] == i && t.list.get(j)[1] == idx) {
//								System.out.println(i + ", " + idx);
								getBall = j + 1;
								Collections.reverse(t.list);
								t.list.get(0)[2] = 1;
								t.list.get(t.list.size()-1)[2] = 3;
								break;
							}
						}
					}
					score += Math.pow(getBall, 2);
					break;
				}
			}
		}
		else if(d == 2) {
			for(int i = n-1; i>=0; i--) {
				if(map[idx][i] > 0 && map[idx][i] < 4) {
					int getBall = 0;
					for(Team t : team) {
						if(getBall > 0) break;
						for(int j = 0; j<t.list.size(); j++) {
							if(t.list.get(j)[0] == idx && t.list.get(j)[1] == i) {
//								System.out.println(idx + ", " + i);
								getBall = j + 1;
								Collections.reverse(t.list);
//								System.out.println(">>>" + t.list.get(0)[0] + " " + t.list.get(0)[1]);
								t.list.get(0)[2] = 1;
								t.list.get(t.list.size()-1)[2] = 3;
								break;
							}
						}
					}
//					System.out.println(getBall);
					score += Math.pow(getBall, 2);
					break;
				}
			}
		}
		else if(d == 3) {
			for(int i = 0; i<n; i++) {
				if(map[i][idx] > 0 && map[i][idx] < 4) {
					int getBall = 0;
					for(Team t : team) {
						if(getBall > 0) break;
						for(int j = 0; j<t.list.size(); j++) {
							if(t.list.get(j)[0] == i && t.list.get(j)[1] == idx) {
//								System.out.println(i + ", " + idx);
								getBall = j + 1;
								Collections.reverse(t.list);
								t.list.get(0)[2] = 1;
								t.list.get(t.list.size()-1)[2] = 3;
								break;
							}
						}
					}
					score += Math.pow(getBall, 2);
					break;
				}
			}
		}
		
		return score;
	}

}
