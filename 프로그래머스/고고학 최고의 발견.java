class Solution {
    public int answer = Integer.MAX_VALUE;
	public int[] row;
	public int[][] map;
	public int[][] dir = new int[][] {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int solution(int[][] clockHands) {
        int n = clockHands.length;
        map = new int[n][n];
        row = new int[n];
        
        dfs(0, clockHands);
        
        return answer;
    }
    
    public boolean check() {
		for(int i = 0; i<map.length; i++) {
			if(map[map.length-1][i] != 0) return false;
		}
		return true;
	}
    
    public void rotate(int x, int y, int n) {
		for(int i = 0; i<dir.length; i++) {
			int a = x + dir[i][0], b = y+dir[i][1];
			if(a < map.length && a >= 0 && b < map.length && b >= 0) {
				map[a][b] = (map[a][b] + n) % 4;
			}
		}
	}
    
    public void deepcopy(int[][] clockHands) {
		for(int i = 0; i<clockHands.length; i++) {
			for(int j = 0; j<clockHands.length; j++) 
				map[i][j] = clockHands[i][j];
		}
	}
    
    public void dfs(int n, int[][] clockHands) {
		if(n == clockHands.length) {
			int ans = 0;
			deepcopy(clockHands);
			for(int j = 0; j<n; j++) {
				if(row[j] != 0) {
					rotate(0, j, row[j]);
					ans+=row[j];
				}
				if(answer < ans) return;
			}
			for(int i = 1; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(map[i-1][j] != 0) {
						int tmp = (map[i-1][j] * 3) % 4 ;
						rotate(i, j, tmp);
						ans+=tmp;
					}
					if(answer < ans) return;
				}
			}
			if(check()) answer = Math.min(answer, ans);
			return;
		}
		
		for(int i = 0; i<4; i++) {
			row[n] = i;
			dfs(n+1, clockHands);
		}
	}
}
