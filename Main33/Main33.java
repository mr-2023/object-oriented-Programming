import oop.ex33.Circle;

class Main33 {
  public static void main(String[] args) {
    Circle c;

    c = new Circle();
    System.out.println("1) For 0 args : " + c);
    
    c = new Circle(3);
    System.out.println("2) For 1 arg  : " + c);
    c = new Circle(4);
    System.out.println("3) For 1 arg  : " + c);
    
    c = new Circle(2, 3);
    System.out.println("4) For 2 args : " + c);
    c = new Circle(4, 5);
    System.out.println("5) For 2 args : " + c);

    c = new Circle(3, 4, 5);
    System.out.println("6) For 3 args : " + c);
    c = new Circle(-1, -2, 2);
    System.out.println("7) For 3 args : " + c);
  }
}