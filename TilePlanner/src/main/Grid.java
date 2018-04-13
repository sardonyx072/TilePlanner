package main;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.HashSet;

public class Grid {
	protected Color bgColor;
	protected Rectangle size;
	protected HashMap<Point,Color> tiles;
	protected HashSet<Point> selected;
	public Grid() {
		this.bgColor = Color.WHITE;
		this.size = new Rectangle(0,0,0,0);
		this.tiles = new HashMap<Point,Color>();
		this.selected = new HashSet<Point>();
		this.includeRange(new Rectangle(0,0,10,10));
		this.select(new Rectangle(0, 0, 1, 1), false, false);
	}
	private void includeRange(Rectangle rect) {
		this.size = (Rectangle) this.size.createUnion(rect);
		for (int x = this.size.x; x < this.size.getMaxX(); x++)
			for (int y = this.size.y; y < this.size.getMaxY(); y++)
				this.tiles.putIfAbsent(new Point(x,y),this.bgColor);
	}
	public void select(Rectangle rect, boolean nonBGonly, boolean append) {
		this.includeRange(rect);
		if (!append)
			this.deselect();
		for (int x = rect.x; x < rect.getMaxX(); x++)
			for (int y = rect.y; y < rect.getMaxY(); y++) {
				Point point = new Point(x,y);
				if (!(nonBGonly && this.tiles.get(point).equals(this.bgColor)) && !this.selected.add(point) && append)
					this.selected.remove(point);
			}
	}
	public void deselect() {
		this.selected.clear();
	}
	public void clear() {
		this.selected.clear();
		for (Point point : this.tiles.keySet())
			this.tiles.put(point, this.bgColor);
	}
	public void colorSelected(Color color) {
		for (Point point : this.selected)
			this.tiles.put(point, color);
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("grid<%d,%d,%d,%d>",this.size.x, this.size.y,this.size.x+this.size.width,this.size.y+this.size.height));
		builder.append(String.format("\nselected: [%s]", String.join(",",this.selected.stream().map(p -> String.format("<%d,%d>", p.x, p.y)).toArray(String[]::new))));
		for (int y = this.size.y; y < this.size.getMaxY(); y++) {
			builder.append("\n");
			for (int x = this.size.x; x < this.size.getMaxX(); x++)
				if (this.tiles.get(new Point(x,y)) == Color.BLACK)
					builder.append(" B");
				else if (this.tiles.get(new Point(x,y)) == Color.YELLOW)
					builder.append(" Y");
				else if (this.tiles.get(new Point(x,y)) == Color.RED)
					builder.append(" R");
				else if (this.tiles.get(new Point(x,y)) == Color.GREEN)
					builder.append(" G");
				else
					builder.append(" W");
		}
		return builder.toString();
	}
}
