import java.util.Scanner;
import java.awt.Graphics;

class Circle extends Figure {
  int r;
 
  void parse(Scanner s) { // "create circle ↓x y r name" 次は ↓ から読み込み
    this.x = s.nextInt(); //  重心:親の Figure クラスのフィールド
    this.y = s.nextInt();
    this.r = s.nextInt(); //  半径: Circle クラスのフィールド
    this.name = s.next(); //  名前:親の Figure クラスのフィールド
  }
 
  void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
 
  void draw(Graphics g) {
    g.drawOval(x - r, y - r, 2 * r, 2 * r);
  }
}
