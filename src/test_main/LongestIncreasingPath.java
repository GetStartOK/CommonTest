package test_main;

public class LongestIncreasingPath {

	int[][] trix = null;
	int[][] paths = null;
	
	public int longestIncreasingPath(int[][]  trix) {
		this.trix = trix;
		this.paths = new int[trix.length][];
        for(int i = 0; i < trix.length; i ++){
        	paths[i] = new int[trix[i].length];
        }
        int res = 0;
        for(int i = 0; i < paths.length; i ++){
        	for(int j = 0; j < paths[i].length; j++){
        		int t = 0;
        		if(paths[i][j] == 0)
        			t = findNodePath(i, j);
                res = res >= t ? res : t;
        	}
        }
        return res;
    }
	
	private int findNodePath(int r, int c){
		if(paths[r][c] != 0)
			return paths[r][c];
		paths[r][c] = 1;
		if(r > 0){
			int t = 0;
			if(trix[r - 1][c] > trix[r][c])
				t = findNodePath(r - 1, c) + 1;
			paths[r][c] = paths[r][c] >= t? paths[r][c] : t;
		}
		if(r < trix.length - 1){
			int t = 0;
			if(trix[r + 1][c] > trix[r][c])
				t = findNodePath(r + 1, c) + 1;
			paths[r][c] = paths[r][c] >= t ? paths[r][c] : t;
		}
		if(c < trix[r].length - 1){
			int t = 0;
			if(trix[r][c + 1] > trix[r][c])
				t = findNodePath(r, c + 1) + 1;
			paths[r][c] = paths[r][c] >= t ? paths[r][c] : t;
		}
		if(c > 0){
			int t = 0;
			if(trix[r][c - 1] > trix[r][c])
				t = findNodePath(r, c - 1) + 1;
			paths[r][c] = paths[r][c] >= t ? paths[r][c] : t;
		}
		return paths[r][c];
	}
	
	public static void main(String[] args) {
		int[][] trix = {{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(trix));
	}

}
