import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class HW2 {

	public static void main(String[] args) {

		ArrayList<Polygon> p = new ArrayList<Polygon>();
		// Two different Triangle in Polygon
		p.add(new Triangle(new Point(0, 0), new Point(0, 2), new Point(2, 0)));
		p.add(new Triangle(new Point(0, 0), new Point(0, 10), new Point(10, 0)));
		// Two different Rectangle in Polygon
		p.add(new Rectangle(new Point(0, 0), new Point(7, 0), new Point(0, 3), new Point(7, 3)));
		p.add(new Rectangle(new Point(0, 0), new Point(4, 0), new Point(0, 6), new Point(4, 6)));
		// add four polygon in Collection ArrayList
		Iterator<Polygon> it = p.iterator();

		while (it.hasNext()) {
			Polygon nextP = it.next();
			if (nextP.getPoint().size() == 3) {
				System.out.println("Triangle Area: " + nextP.getArea());
			} else {
				System.out.println("Rectangle Area: " + nextP.getArea());
			}

		}

	}

}
