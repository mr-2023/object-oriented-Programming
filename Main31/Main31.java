public class Main31 {
  public static boolean contains(String str, String []list) {
    for(String s : list) {
      if(str.equals(s)) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String str = "apple";
    String []fruits1 = { "orange", "banana", "grape", "pineapple" };
    String []fruits2 = { "apple", "peach", "grapefruit" };
    System.out.println(str + " is in the list 1 : " + contains(str, fruits1));
    System.out.println(str + " is in the list 2 : " + contains(str, fruits2));
    str = "pine" + str;
    //ポインタは違うが、同じ文字列
    System.out.println(str + " is in the list 1 : " + contains(str, fruits1));
    System.out.println(str + " is in the list 2 : " + contains(str, fruits2));
    str = "grapefruit";
    System.out.println(str + " is in the list 1 : " + contains(str, fruits1));
    System.out.println(str + " is in the list 2 : " + contains(str, fruits2));
    str = str.substring(0, 5);
    //ポインタは違うが、同じ文字列
    System.out.println(str + " is in the list 1 : " + contains(str, fruits1));
    System.out.println(str + " is in the list 2 : " + contains(str, fruits2));
  }
}