package oop.ex35;

public class PersonID2 {
  final protected int year, serial;
  public PersonID2(int year, int serial) {
    this.year = year; this.serial = serial;
  }
  @Override
  public String toString() {
    return String.format("%02dB%05d", year, serial);
  }
  @Override
  public int hashCode(){
    //事実上の線形探索となる
    return 1000;
  }
}
