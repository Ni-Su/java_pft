public class MyFiPro {

	public static void main(String[] args){
		hello("all");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
	}
	public static void hello(String someboby){
		System.out.println("Hello, " + someboby + "!!!");
	}

	public static double area(Square s){
		return s.l * s.l;
	}

	public static double area(Rectangle r) {
		return r.a * r.b;
	}
}