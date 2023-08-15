
import java.awt.Color;
import java.awt.Graphics;
// Expert Pattern used
public class Triangle extends Shape {
	private int x, y;
	private int height;
	private int width;
	private Graphics graphics;

	public Triangle(int x, int y, int height, int width, Graphics graphics) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.graphics = graphics;
	}

	@Override
	public void draw() {
		
		int[] xCoordinates = new int[3];
		xCoordinates[0] = this.x;
		xCoordinates[1] = this.x - (this.width/2) ; 
		xCoordinates[2] = this.x + (this.width/2) ; 
		int[] yCoordinates = new int[3];
		yCoordinates[0] = this.y;
		yCoordinates[1] = this.y + this.height;
		yCoordinates[2] = this.y + this.height; 
		this.graphics.setColor(Color.black);
		this.graphics.drawPolygon(xCoordinates,yCoordinates, 3);

	}

}