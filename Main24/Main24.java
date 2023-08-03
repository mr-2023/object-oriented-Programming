import oop.ex24.*;

class Main24 {
  public static void main(String[] args) {
    RangeGenerator range = new RangeGenerator(10, 1, 5);
    RandomGenerator random = new RandomGenerator(10);
    for(int i = 0; i < 5; ++i) {
      System.out.printf("RangeGenerator %d : %d\n", i, range.next());
    }
    for(int i = 0; i < 5; ++i) {
      System.out.printf("RandomGenerator %d : %d\n", i, random.next());
    }
    System.out.println("Reset generators");
    range.init(11);
    random.init(482710);
    for(int i = 0; i < 5; ++i) {
      System.out.printf("RangeGenerator %d : %d\n", i, range.next());
    }
    for(int i = 0; i < 5; ++i) {
      System.out.printf("RandomGenerator %d : %d\n", i, random.next());
    }
  }
}