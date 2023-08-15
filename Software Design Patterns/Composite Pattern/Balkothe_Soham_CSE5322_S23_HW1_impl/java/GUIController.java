
import java.awt.Graphics;

// Controller Pattern Exceution
public class GUIController {
	String buttonClicked;
	Shape shape;

	public GUIController() {
		super();
		this.shape = new ShapeComposite();
	}

	public void mouseClicked(int x, int y, Graphics g) {
		try {
			switch (this.buttonClicked) {
				case "Triangle":
					this.shape.add(new Triangle(x, y, 80, 80, g));
					break;
				case "Box":
					this.shape.add(new Box(x, y, 80, 80, g));
					break;
				case "Circle":
				default:
					this.shape.add(new Circle(x, y, 80, 80, g));
					break;
				
			}
		}
		catch(Exception e){
			System.out.println("No button selected");
		}
		this.shape.draw();
		System.out.println("User Clicked at point : " + x + " " + y);
	}

	public void selectCircle() {
		this.buttonClicked = "Circle";
		System.out.println("Circle button clicked");
	}

	public void selectBox() {
		this.buttonClicked = "Box";
		System.out.println("Box button clicked");
	}

	public void selectTriangle(){
		this.buttonClicked = "Triangle";
		System.out.println("Triangle button clicked");
	}

}
