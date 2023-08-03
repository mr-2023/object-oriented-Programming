import java.util.HashSet;
import oop.ex35.PersonID;
import oop.ex35.PersonID2;

class Main35 {
  public static void main(String[] args) {
    HashSet<PersonID> p1 = new HashSet<>(7000);
    System.out.println("For Good case");
    //この時間から計測
    long start = System.nanoTime();
    for(int i = 0; i < 20000; i+=4) {
     p1.add(new PersonID(20, i));
    }
    //この時間まで計測
    long end = System.nanoTime();
    System.out.println("Add 5000 data: " + ((end - start) / 1000) + " us");
    start = System.nanoTime();
    for(int i = 0; i < 10000; ++i) {
      p1.contains(new PersonID(20, i));
    }
    end = System.nanoTime();
    System.out.println("Check 10000 data: " + ((end - start) / 1000) + " us");

    p1 = null;
    System.gc();

    HashSet<PersonID2> p2 = new HashSet<>(7000);
    System.out.println("For Bad case");
    start = System.nanoTime();
    for(int i = 0; i < 20000; i+=4) {
      p2.add(new PersonID2(20, i));
    }
    end = System.nanoTime();
    System.out.println("Add 5000 data: " + ((end - start) / 1000) + " us");
    start = System.nanoTime();
    for(int i = 0; i < 10000; ++i) {
      p2.contains(new PersonID2(20, i));
    }
    end = System.nanoTime();
    System.out.println("Check 10000 data: " + ((end - start) / 1000) + " us");
  }
}