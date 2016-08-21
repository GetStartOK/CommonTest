package test_main.listlterator;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static int xedge = 0;
	private static int yedge = 0;
	
	public static int getResult(String[][] metrix, Point start, Point[] bs){
		List<Point> des = new ArrayList<Point>();
		for(int i = 0; i < metrix.length; i++){
			String[] m = metrix[i];
			for(int j= 0; j < m.length; j++){
				if(m.equals(".")){
					des.add(new Point(i, j));
				}
			}
		}
		
		for(Point d : des){
			int i = canGet(start, d, bs, metrix, 0);
		}
		
		return 0;
	}
	
	private static int canGet(Point current, Point dest, Point[] bs, String[][] metrix, int n) {
		if(current.x == dest.x && current.y == dest.y)
			return n;
		List<Point> can = new ArrayList<Point>();
		for(Point b : bs){
			Point p = canWalk(current, b, metrix, 1);
			if(p != null){
				can.add(p);
			}
			for(Point c : can){
				if(canGet(c, dest, bs, metrix, n++));
			}
		}
		
		return -1;
	}

	public static Point canWalk(Point current, Point b, String[][] metrix, int n) {
		int x = current.x + b.x;
		int y = current.y + b.y;
		if(x < 0 || x > xedge)
			return null;
		if(y < 0 || y > yedge)
			return null;
		if(metrix[x][y].equals("X"))
			return null;
		Point p = new Point(x, y);
		p.is = true;
		return p;
	}

	public static void main(String[] args) {
		
	}
}

class Point{
	int x;
	int y;
	boolean isGet = false;
	int steps;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
