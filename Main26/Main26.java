import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Main26 {
  static int a = 10;
  static String buf = null;

  public static int m1() {
    //0徐算NG
    try {
      for (int i = 0; i < 10; i++) {
        a -= i;
        a /= a;
      }
    } catch (ArithmeticException e) {
      System.out.println(e);//算術計算で例外的条件が発生した場合に投げられるエラー(0徐算)
    }
    return a;
  }

  public static int m2() {
    //bufの長さを後に求めるので、bufには何らかの文字が必要(=NULLではだめ)
    try {
      if (buf == null) {
        throw new NullPointerException("Cannot invoke \"String.length()\" because \"Main26.buf\" is null");
      }
    } catch (NullPointerException e) {
      System.out.println(e);//オブジェクトが必要なのに、アプリケーションがnullを使おうとすると出現するエラー
    } finally {
      if (buf == null) {
        return -1;
      } else {
        return buf.length();
      }
    }
  }

  public static int m3(int b) {
    //bが０以上の値であることを要求(= b<0の時は不適切)
    try {
      if (b < 0) {
        throw new IllegalArgumentException("For input: " + b);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e); //不正な引数、または不適切な引数をメソッドに渡した場合に投げられるエラー
    } finally {
      if (b < 0) {
        b = 0;
      }
      return b;
    }
  }

  public static void main(String[] args) {
    //入力なし:NullPointerException  argsの一つ目の数字を値として使う
    //argsの一つ目の引数が10進数の整数ではない: NumberFormatException 63行目でargs[0]を整数に直す
    try {
      if (args.length == 0) {
        throw new NullPointerException("For input string: null");
      }
      int select = Integer.parseInt(args[0]);

      switch (select) {
        case 1:
          m1();
          break;

        case 2:
          m2();
          break;

        default:
          m3(select);
      }
    } catch (NullPointerException e) {
      System.out.println(e);
    } catch (NumberFormatException e) {
      System.out.println(e);
    }

    try {
      FileInputStream fi = new FileInputStream("no_such_file");
      System.out.println(fi.available());
    }catch(FileNotFoundException e) {
      //必要な場所にそのファイルがない。ディレクトリである、および、何故かそのファイルが開けない時に発生
      System.out.println(e);
    }catch(SecurityException e){
      //セキュリティ上の都合で、セキュリティマネージャにファイルを開くことをブロックされた場合に発生
      System.out.println(e);
    }catch(IOException e){
      //availableが発生させる例外:入出力エラーで投げるエラー
      e.printStackTrace();
    }
    System.out.println("Successfully finished");
  }
}