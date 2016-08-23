package test_main;

public class FindMaxArea {

	public int findMaxArea(int[][] area){
		int max = Integer.MIN_VALUE;
		int r = area.length;
		int c = area[0].length;
		int r1, r2, c1, c2;
		for(r1 = 1; r1 < r - 1; r1++){
			for(r2 = 2; r2 < r; r2 ++){
				for(c1 = 1; c1 < c - 1; c1 ++){
					for(c2 = 2; c2 < c; c2 ++){
						max = Math.max(max, getMin(area, r1, r2, c1, c2));
					}
				}
			}
		}
		return max;
	}
	
	private int getMin(int[][] area, int r1, int r2, int c1, int c2){
		int min = Integer.MAX_VALUE;
		min = Math.min(min, getArea(area, 0, r1, 0, c1));
		min = Math.min(min, getArea(area, r1, r2, 0, c1));
		min = Math.min(min, getArea(area, r2, area.length, 0, c1));
		min = Math.min(min, getArea(area, 0, r1, c1, c2));
		min = Math.min(min, getArea(area, r1, r2, c1, c2));
		min = Math.min(min, getArea(area, r2, area.length, c1, c2));
		min = Math.min(min, getArea(area, 0, r1, c2, area[0].length));
		min = Math.min(min, getArea(area, r1, r2, c2, area[0].length));
		min = Math.min(min, getArea(area, r2, area.length, c2, area[0].length));
		return min;
	}
	
	private int getArea(int[][] area, int rs, int re, int cs, int ce){
		int res = 0;
		for(int i = rs; i < re; i++){
			for(int j = cs; j < ce; j++){
				res += area[i][j];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] area = {{1,2,2,3,2,4},{4,3,3,2,2,1},{2,3,3,4,3,1},{1,3,4,5,3,2}};
		System.out.println(new FindMaxArea().findMaxArea(area));
	}

}
