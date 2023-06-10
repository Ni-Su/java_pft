import java.awt.*;

public class MyFiPro {

	public static void main(String[] args){
		hello("all");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 5);
		System.out.println(p1.x + ", " + p1.y + " и " + p2.x + ", " + p2.y);

		Segment seg = new Segment(1, 1, 1, 5);
		System.out.println("Длинна отрезка " + seg.distance());
	}
	public static void hello(String someboby){
		System.out.println("Hello, " + someboby + "!!!");
	}





	}
