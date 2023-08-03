package oop.ex22;

public class Ticket {
  public final static int MAX_NUM = 10;
  private static boolean[] used = new boolean[MAX_NUM];
  private int number;
  public Ticket(int number) {
    if(number < 0 || number >= MAX_NUM || used[number]) this.number = -1;
    else {
      this.number = number;
      used[number] = true;
    }
  }
  public boolean isValid() {
    return number >= 0;
  }
  public void release() {
    if(number >= 0) used[number] = false;
    number = -1;
  }
}