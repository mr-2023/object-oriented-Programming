package oop.ex23;

public abstract class Figure {
  abstract public double getArea();
  public int compareTo(Figure f) {
    double sub = getArea() - f.getArea();
    if(sub < 0) {
      return -1;
    }
    if(sub > 0) {
      return 1;
    }
    return 0;
  }
}