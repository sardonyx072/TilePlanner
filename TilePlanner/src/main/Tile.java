package main;

import java.awt.Color;
import java.awt.Point;

public class Tile extends Point {
	private static final long serialVersionUID = -4956760027403537181L;
	private Color color;
	public Tile(int x, int y, Color color) {
		super(x,y);
		this.color = color;
	}
	public Color getColor() {return this.color;}
	public void setColor(Color color) {this.color = color;}
	public String toString() {return String.format("{RGB[%d,%d,%d]@LOC[%d,%d]}", this.color.getRed(),this.color.getGreen(),this.color.getBlue(),this.x,this.y);}
}
