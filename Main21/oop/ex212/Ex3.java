package oop.ex212;

import oop.ex21.Ex1;

public class Ex3 extends Ex1 {
  public int method4() {
    //System.out.println(method2());
    // method2 should not be visible here
    return this.field;
  }
}