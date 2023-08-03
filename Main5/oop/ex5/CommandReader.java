package oop.ex5;
import java.util.Scanner;
import java.io.*;

public class CommandReader {
    private TableList tables = new TableList();
    //１行分のコマンドの文字列を読み込み、TableListとTableに仕事を割り振る
    public void executeCommand(String code){
        Scanner readingPoint = new Scanner(code);
        String fileName, onePassage, tableName, outputName, columnName, fieldName,column1, column2;
        String word;
        Table originalTable, targetTable, originalTable1, originalTable2;
        //最初の一単語を読み込む
        word = readingPoint.next();
        if(word.equals("create")){
            tables.create(readingPoint);
        }else if(word.equals("show")){
            tables.printTable(readingPoint.next());
        }else if(word.equals("list")){
            tables.printAllName();
        }else if(word.equals("delete")){
            tables.delete(readingPoint.next());
        }else if(word.equals("insert")){
            targetTable = tables.getTable(readingPoint.next());
            targetTable.insert(readingPoint);
        }else if(word.equals("update")){
            targetTable = tables.getTable(readingPoint.next());
            targetTable.update(readingPoint);
        }else if(word.equals("remove")){
            targetTable = tables.getTable(readingPoint.next());
            targetTable.remove(readingPoint);
        }else if(word.equals("load")){
            fileName = readingPoint.next();
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
                onePassage = br.readLine();
                while(onePassage != null){
                    this.executeCommand(onePassage);
                    onePassage = br.readLine();
                }
            }catch(FileNotFoundException e){
                System.out.println(fileName + " is not exist.");
            }catch(IOException e){
                System.out.println(e);
            }
        }else if (word.equals("save")){
            tableName = readingPoint.next();
            outputName = readingPoint.next();
            targetTable = tables.getTable(tableName);
            try(FileWriter fw = new FileWriter(outputName)){
                targetTable.write(fw, tableName);
            }catch(IOException e){
                System.out.println(e);
            }
        }else if(word.equals("rename")){
            targetTable = tables.getTable(readingPoint.next());
            targetTable.rename(readingPoint);
        }else if(word.equals("select")){
            originalTable  = tables.getTable(readingPoint.next());
            columnName = readingPoint.next();
            fieldName = readingPoint.next();
            targetTable = tables.getTable(readingPoint.next());
            originalTable.select(columnName, fieldName, targetTable);
        }else if(word.equals("proj")){
            originalTable = tables.getTable(readingPoint.next());
            targetTable = tables.getTable(readingPoint.next());
            targetTable.copyByColumn(originalTable);
        }else if(word.equals("join")){
            //テーブルとカラム名の読み込み
            originalTable1 = tables.getTable(readingPoint.next());
            column1 = readingPoint.next();
            originalTable2 = tables.getTable(readingPoint.next());
            column2 = readingPoint.next();
            targetTable = tables.getTable(readingPoint.next());
            targetTable.join(originalTable1, column1, originalTable2, column2);
        }else if (word.equals("clear")){
            tables.clear();
        }else {
            System.out.format("command %s is not valid.\n", word);
        }

    }

}
