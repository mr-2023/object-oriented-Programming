import java.io.*;

class Main44 {
  public static void main(String[] args) {
    String fileName = args[0];
    int sentenceNum=0,wordNum=0;
    try(BufferedReader br = new  BufferedReader(new FileReader(fileName))){
      String oneLine = br.readLine();
      String passage = new String(oneLine);
      oneLine = br.readLine();
      while(oneLine != null){
        passage = passage + " " + oneLine;
        oneLine = br.readLine();
      }
      //調整
      passage = passage.replace(", ", ",");
      passage = passage.replace("  ", " ");
      passage = passage.replace(". ", ".");
      sentenceNum = passage.split("[.:]").length;
      wordNum = passage.split("[ ,:.]").length;

    }catch(FileNotFoundException e){
      System.out.println(fileName + " is not exist.");
    }catch(IOException e){
      System.out.println(e);
    }
    System.out.println("word num: " + wordNum);
    System.out.println("sentence num: " + sentenceNum);
  }
}