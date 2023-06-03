public class Segment {

    public double x;
    public double y;
    public double x2;
    public double y2;

    //конструктор;
    public Segment(double x, double y, double x2, double y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
   //метод;
    public double distance() {
        double n = this.x2 - this.x;
        double m = this.y2 - this.y;
        return Math.sqrt(Math.pow(n, 2) + Math.pow(m, 2));
    }
}
