import java.awt.*;
import java.util.*;
import java.awt.event.*;
 
@SuppressWarnings("serial")
public class DrawDemo extends Canvas implements ActionListener {
  public HashMap<String, Figure> figList;
 
  public DrawDemo() {
    Frame f = new Frame("Welcome to Drawing Demo");
    TextField userInput = new TextField(" Input commands here ");
    f.addWindowListener(new WindowAdapter() { //  ウィンドウを閉じると終了
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    f.setLayout(new BorderLayout()); //  ウィンドウ内の部品の配置
    f.setSize(800, 600);
    f.add("North", userInput);
    f.add("Center", this);
    userInput.addActionListener(this); //  テキストフィールドのリスナ設定
    f.setVisible(true); //  ウィンドウを見せる
    figList = new LinkedHashMap<String, Figure>(); //  図形を管理するリスト
  }
 
  public void paint(Graphics g) { // figList 中にある図形を再描画時に描画
    for(Figure f : figList.values()) { // figList 中にある図形を列挙
      f.draw(g); //  各図形インスタンスの描画メソッドを呼ぶ
    }
  }
 
  // actionPerformed: ActionListner のメソッド ( インタフェースの実装 )
  public void actionPerformed(ActionEvent e) { //  入力完了時の処理
    String str = ((TextField) e.getSource()).getText(); //  入力文字列
    executeCommand(str);
  }
 
  // コマンド実行用メソッド
  public void executeCommand(String str) {
    Scanner kb = new Scanner(str); //  入力文字列の Scanner を生成
    Figure fig; //  作業用変数
    int x, y;
 
    str = kb.next(); //  最初のトークン ( コマンドのはず ) 読み込み
    if (str.equals("create")) { //  新しい図形の生成 ?
      str = kb.next(); //  図形のタイプを読み込み,インスタンス生成
      if (str.equals("circle")) {
        fig = new Circle();
      } else if (str.equals("triangle")) {
        fig = new Triangle();
      } else if (str.equals("rectangle")) {
        fig = new Rectangle();
      } else { //  知らない図形タイプ
        fig = null;
        System.out.println(" そんなん作れません ");
      }
      if (fig != null) { //  インスタンスを生成したら parse メソッドに
        fig.parse(kb); // Scanner を渡して残りのパラメタを処理
        figList.put(fig.getName(), fig); //  リストに図形を登録
      }
    } else if (str.equals("move")) { //  既存の図形を移動 ?
      str = kb.next(); //  図形の名前を読み込み
      fig = figList.get(str); //  図形リストを検索
      if (fig == null) {
        System.out.println(str + " なんてないっす ");
      } else { //  移動量を読み込んで move メソッドを呼ぶ
        x = kb.nextInt();
        y = kb.nextInt();
        fig.move(x, y);
      }
    } else if (str.equals("delete")) { //  既存の図形を削除 ?
      str = kb.next(); //  図形の名前を読み込み
      if (figList.get(str) != null) { //  あれば削除
        figList.remove(str);
      } else {
        System.out.println(str + " なんてないっす ");
      }
    } else if (str.equals("clear")) { //  画面クリア ?
      figList.clear(); //  図形リストをクリア
    } else if (str.equals("exit")) { //  プログラム終了 ?
      System.exit(0);
    } else {
      System.out.println(" 何いってんのかわかりません ");
    }
    repaint(); // Canvas クラスのメソッド
  }
}
