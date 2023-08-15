
import java.util.ArrayList;
import java.util.Iterator;

//Composite pattern
public class ShapeComposite extends Shape {
	private ArrayList<Shape> queue = new ArrayList<Shape>();
	

	public void add(Shape shape) {
		queue.add(shape);
	}

	@Override
	public void draw() {
		// iterator pattern used
		Iterator value = queue.iterator();
		while (value.hasNext()) {
			((Shape) value.next()).draw();
		}
	}

}
