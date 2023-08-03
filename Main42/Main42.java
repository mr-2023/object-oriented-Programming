import java.io.File;
import java.io.IOException;
import java.nio.file.*;

class Main42 {
  public static void main(String[] args) {
    String objectFile = "OOPsample";
    Path homePath = Paths.get(System.getProperty("user.home"));
    File[] fileList = homePath.toFile().listFiles();
    String objectPath = null;
    int flagD = 0;
    int flagF = 0;
    for (File file: fileList){
      if (file.getName().equals(objectFile)){
        if (file.isDirectory()){
          flagD = 1;
        }else{
          flagF = 1;
        }
        objectPath = file.getPath();
        if(flagD == 1 && flagF == 1){
          break;
        }
      }
    }
    if (flagD==1){
      System.out.println("true");
    }else{
      System.out.println("false");
    }
    if (flagF==1){
      System.out.println("true");
    }else{
      System.out.println("false");
    }
    if(flagD == 1 || flagF == 1){
      System.out.format("%sは存在します", objectPath.toString());
    }else{
      try {
        Path createPath = homePath.resolve(objectFile);
        Files.createDirectory(createPath);
        System.out.format("%sを作成しました\n", createPath.toString());
      }catch(IOException e){
        System.out.println("ファイル作成に失敗しました");
      }
    }
  }
}