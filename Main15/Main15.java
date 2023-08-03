class Main15 {
  public static void main(String[] args) {
    DrawDemo drawdemo = new DrawDemo();
    drawdemo.executeCommand("create circle 400 250 200 c1");
    drawdemo.executeCommand("create triangle 0 50 300 450 600 50 t1");
    //(1)
    drawdemo.executeCommand("delete c1");
    //(2)
    drawdemo.executeCommand("move t1 100 50");
    //(3)
    drawdemo.executeCommand("create rectangle 400 300 600 400 r1");
    //(4)
    drawdemo.executeCommand("clear");
  }
}