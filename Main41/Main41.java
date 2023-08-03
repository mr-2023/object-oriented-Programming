import java.io.*;
import java.util.*;
class Main41 {
  public static void main(String[] args) {
    String fileName = "output.txt";
    ArrayList<String> arrayStr = new ArrayList<>();
    //(1) ファイルの読み込み
    try(BufferedReader br = new  BufferedReader(new FileReader(fileName))){
      String one_str = br.readLine();
      while(one_str != null){
        arrayStr.add(one_str);
        one_str = br.readLine();
      }
    }catch(FileNotFoundException e){
      System.out.println(fileName + " is not exist.");
    }catch(IOException e){
      System.out.println(e);
    }
    //(2)追記モード
    int flag;
    try(FileWriter fw = new FileWriter(new File(fileName), true)){
      for (String tmp1:args){
        flag = 0;
        for (String tmp2:arrayStr){
          if(tmp1.equals(tmp2)){
            flag = 1;
            break;
          }
        }
        if(flag == 0){
          System.out.println(tmp1);
          fw.write(tmp1+"\n");
        }
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }
}