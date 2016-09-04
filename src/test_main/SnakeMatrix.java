package test_main;

import java.util.*;

public class SnakeMatrix{

  	int[][] matrix = null;
	public int[][] getMatrix(int n){
  		matrix = new int[n][n];
      int di = 0;
      int r = 0, c = 0;
      for(int i = 0; i < n*n; i ++){
        if(di == 0){
        	matrix[r][c] = i + 1;
          if(c == n - 1 || matrix[r][c + 1] != 0)
          {
          	di = 1;
            r ++;
          }else{
          	c ++;
          }
        }else if(di == 1){
        	matrix[r][c] = i + 1;
          if(r == n - 1 || matrix[r + 1][c] != 0){
          	di = 2;
            c --;
          }else{
          	r ++;
          }
        }else if(di == 2){
        	matrix[r][c] = i + 1;
          if(c == 0 || matrix[r][c - 1] != 0){
          	di = 3;
            r --;
          }else{
          	c --;
          }
        }else if(di == 3){
        	matrix[r][c] = i + 1;
          if(matrix[r - 1][c] != 0){
          	di = 0;
            c ++;
          }else{
          	r --;
          }
        }
      }
      return matrix;
 	}

  public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    SnakeMatrix sm = new SnakeMatrix();
    int[][] res = sm.getMatrix(n);
    for(int i = 0; i < n; i ++)
      for(int j = 0; j < n; j++){
    	System.out.print(res[i][j]);
    }
  }
}