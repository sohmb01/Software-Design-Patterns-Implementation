
import java.awt.Color;
import java.awt.Graphics;
// Expert Pattern used
public class Circle extends Shape {
	private int x, y;
	private int height;
	private int width;
	private Graphics graphics;

	public Circle(int x, int y, int height, int width, Graphics graphics) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.graphics = graphics;
	}

	@Override
	public void draw() {
		
		this.graphics.setColor(Color.white);
		this.graphics.fillOval(this.x, this.y, this.height, this.width);
		this.graphics.setColor(Color.black);
		this.graphics.drawOval(this.x, this.y, this.height, this.width);
		
	}

}