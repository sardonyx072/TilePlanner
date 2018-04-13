package main;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		System.out.println(new Tile(0,0,Color.BLACK).equals(new Tile(0,0,Color.WHITE)));
		System.out.println(new Rectangle(0,0,1,1).createUnion(new Rectangle(2,2,1,1)));
		HashMap<Point,Color> colors = new HashMap<Point,Color>();
		colors.put(new Point(0,0), Color.WHITE);
		System.out.println(colors.containsKey(new Point(0,0)));
		Grid grid = new Grid();
		System.out.println(grid);
		grid.select(new Rectangle(1,1,1,1), false, false);
		grid.colorSelected(Color.BLACK);
		System.out.println(grid);
		grid.select(new Rectangle(3,0,2,3), false, false);
		grid.colorSelected(Color.BLACK);
		System.out.println(grid);
		grid.select(new Rectangle(2,0,4,1), false, true);
		grid.colorSelected(Color.YELLOW);
		System.out.println(grid);
		grid.select(new Rectangle(0,0,3,3), true, false);
		grid.colorSelected(Color.RED);
		System.out.println(grid);
		grid.select(new Rectangle(1,0,3,3), true, true);
		grid.colorSelected(Color.GREEN);
		System.out.println(grid);
		HashSet<Point> set = new HashSet<Point>();
		set.add(new Point(0,0));
		System.out.println(set.contains(new Point(0,0)));
	}
}
