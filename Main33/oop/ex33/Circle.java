package oop.ex33;

public class Circle extends Figure {
  public final int r;
  public Circle(){
    super();
    this.r = 1;
  }
  public Circle(int r){
    this.r = r;
  }
  public Circle(int x, int y){
    super(x, y);
    this.r = 1;
  }
  public Circle(int x, int y, int r){
    super(x, y);
    this.r = r;
  }
  //文字列とクラスCircleを足すと、CircleをtoStringして文字列と足す
  @Override
  public String toString() {
    return super.toString() + "-rad:" + r;
  }
}
