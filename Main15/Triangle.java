import java.util.Scanner;

class Triangle extends Polygon {
  void parse(Scanner s) { // "create triangle ↓x1 y1 x2 y2 x3 y3 name"
    this.xs = new int[3];
    this.ys = new int[3];
    this.xs[0] = s.nextInt();
    this.ys[0] = s.nextInt();
    this.xs[1] = s.nextInt();
    this.ys[1] = s.nextInt();
    this.xs[2] = s.nextInt();
    this.ys[2] = s.nextInt();
    this.name = s.next();
    this.x = (xs[0] + xs[1] + xs[2]) / 3;
    this.y = (ys[0] + ys[1] + ys[2]) / 3;
  }
}
