import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;

class Main43 {
  public static void main(String[] args) {
    LocalDateTime today = LocalDateTime.now();
    LocalDateTime d1 = today.minusDays(1000);
    LocalDateTime d2 = today.minusDays(1095);
    LocalDateTime d3 = today.minusYears(3);
    LocalDateTime d4 = today.plusMonths(1);
    DateTimeFormatter f1 = DateTimeFormatter.ofPattern("u年MM月dd日(E)");
    DateTimeFormatter f2 = DateTimeFormatter.ofPattern("Gy年MM月dd日");
    System.out.println("今日");
    System.out.println(today.format(f1));
    System.out.println(JapaneseDate.from(today).format(f2));
    System.out.println("1000日前");
    System.out.println(d1.format(f1));
    System.out.println(JapaneseDate.from(d1).format(f2));
    System.out.println("1095日前");
    System.out.println(d2.format(f1));
    System.out.println(JapaneseDate.from(d2).format(f2));
    System.out.println("3年前");
    System.out.println(d3.format(f1));
    System.out.println(JapaneseDate.from(d3).format(f2));
    System.out.println("１ヶ月後");
    System.out.println(d4.format(f1));
    System.out.println(JapaneseDate.from(d4).format(f2));
  }
}