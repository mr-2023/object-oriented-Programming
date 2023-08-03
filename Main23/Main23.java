import oop.ex23.*;

public class Main23 {
  public static void main(String[] args) {
    Figure c1 = new Circle(2.0);
    Figure r1 = new Rectangle(2.0, 3.0);
    Figure r2 = new Rectangle(12.0, 0.5);

    System.out.println(c1.getArea());
    System.out.println(r1.getArea());
    System.out.println(r2.getArea());
    
    System.out.println(c1.compareTo(r1));
    System.out.println(r1.compareTo(c1));
    System.out.println(r2.compareTo(r1));
  }
}