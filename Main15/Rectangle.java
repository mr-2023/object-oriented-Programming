import java.util.Scanner;

class Rectangle extends Polygon {
  int w, h;
 
  void parse(Scanner s) { // "create rectangle ↓x y w h name"
    this.xs = new int[4];
    this.ys = new int[4];
    this.x = s.nextInt();
    this.y = s.nextInt();
    this.w = s.nextInt();
    this.h = s.nextInt();
    this.name = s.next();
    this.xs[0] = x - w / 2;
    this.ys[0] = y - h / 2;
    this.xs[1] = x + w / 2;
    this.ys[1] = y - h / 2;
    this.xs[2] = x + w / 2;
    this.ys[2] = y + h / 2;
    this.xs[3] = x - w / 2;
    this.ys[3] = y + h / 2;
  }
}
