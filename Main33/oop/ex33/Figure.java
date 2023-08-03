package oop.ex33;

public class Figure {
  public final int x, y;
  public Figure() {
    x = y = 0;
  }
  public Figure(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
