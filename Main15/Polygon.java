import java.awt.Graphics;

abstract class Polygon extends Figure { // Triangle, Rectangle に共通の
  int[] xs, ys; // move, draw を実装
 
  void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
    for (int i = 0; i < xs.length; i++) {
      this.xs[i] += dx;
      this.ys[i] += dy;
    }
  }
 
  void draw(Graphics g) {
    g.drawPolygon(xs, ys, xs.length);
  }
}
