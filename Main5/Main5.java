import java.util.Scanner;
import oop.ex5.*;

class Main5 {
  public static void main(String[] args) {
    // このメソッドは好きに変更して構いません（このコメントは消してください）
    Scanner scan = new Scanner(System.in);
    CommandReader reader = new CommandReader();

    while(scan.hasNextLine()) {
      // WindowsのコマンドプロンプトならCTRL+Z、Linux/UnixならCTRL+Dで終端にできます
      String line = scan.nextLine();
      reader.executeCommand(line);
    }
  }
}
