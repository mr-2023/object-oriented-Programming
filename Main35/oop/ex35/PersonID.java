package oop.ex35;
import java.lang.Math;

public class PersonID {
  final protected int year, serial;
  public PersonID(int year, int serial) {
    this.year = year; this.serial = serial;
  }
  @Override
  public String toString() {
    return String.format("%02dB%05d", year, serial);
  }
  @Override
  public int hashCode(){
    //personIDをhashに入力すると、index(郵便番号のようなもの)が返ってきて、大体の位置(エリア)が分かる（その中を捜索する）
    //System.out.println(String.format("%02d%05d", year, serial));
    return year * (int)Math.pow(10, 5) + serial;
  }
}
