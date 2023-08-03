import oop.ex25.*;

class Main25 {
  public static void main(String[] args) {
    Element seg = new Segment(300, 200, 400, 300);
    seg.print();
    System.out.println();
    Element c = new Circle(300, 300, 50);
    c.print();
    System.out.println();
    Element g = new Group(seg, c);
    seg.move(-50, 50);
    g.print();
    System.out.println();
    g = new Group(g, new Circle(300, 300, 30), new Segment(350, 250, 250, 350));
    g.print();
    System.out.println();
    g.move(-300, -250);
    g.print();
  }
}