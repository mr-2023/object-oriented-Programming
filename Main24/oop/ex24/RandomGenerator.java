package oop.ex24;

public class RandomGenerator implements Iterator, Initializable {
  protected int current;
  public RandomGenerator(int seed) {
    current = seed;
  }
  public int next() {
    current = (int)((48271L * current) % (1L << 31 - 1)); // 線形合同法
    return current;
  }
  public void init(int n){
    current = n;
  }
}