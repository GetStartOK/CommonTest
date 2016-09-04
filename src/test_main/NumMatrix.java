package test_main;

public class NumMatrix {

	private int[][] sum = null;

    public NumMatrix(int[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0)
    		return;
    	int r = matrix.length;
    	int c = matrix[0].length;
        sum = new int[r][c];
        sum[0][0] = matrix[0][0];
        for(int i = 0; i < r; i++){
        	for(int j = 0; j < c; j ++){
        		int t = matrix[i][j];
        		if(j > 0){
        			t += sum[i][j - 1];
        		}
        		if(i > 0){
        			t += sum[i - 1][j];
        		}
        		if(i > 0 & j > 0){
        			t -= sum[i - 1][j - 1];
        		}
        		sum[i][j] = t;
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int h = sum[row2][col2];
        if(row1 > 0){
        	h -= sum[row1 - 1][col2];
        }
        if(col1 > 0){
        	h -= sum[row2][col1 - 1];
        }
        if(row1 > 0 & col1 > 0){
        	h += sum[row1 - 1][col1 - 1];
        }
        return h;
    }
	
	public static void main(String[] args) {
		
	}

}
