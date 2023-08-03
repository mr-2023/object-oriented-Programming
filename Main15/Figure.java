import java.util.Scanner;
import java.awt.Graphics;

abstract class Figure {
  int x, y; //  重心の (x,y) 座標
  String name; //  図形の名前
 
  public String getName() {
    return name;
  } //  名前を返す
 
  abstract void parse(Scanner s); //  以下抽象クラス
 
  abstract void move(int dx, int dy); //  これらは派生クラスで実装される
 
  abstract void draw(Graphics g); //  図形毎に処理が違う !
}
