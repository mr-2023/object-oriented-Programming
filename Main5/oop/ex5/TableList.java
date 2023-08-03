package oop.ex5;
import java.util.LinkedList;
import java.util.Scanner;

//tableとtableの名前の管理
public class TableList {
    private TableNameSaver tableNames = new TableNameSaver();
    private LinkedList<Table> tableList = new LinkedList<>();
    //新しいテーブルの作成（既にその名前のテーブルがある場合には何もしない）
    public void create(Scanner scanner){
        String tableName;
        tableName = scanner.next();
        if(! tableNames.contains(tableName)) {
            tableNames.saveName(tableName);
            tableList.add(new Table(scanner));
        }
    }
    //tableNameという名前のテーブルのカラムとフィールドを表示
    public void printTable(String tableName){
        Table tmp;
        tmp = tableList.get(tableNames.indexOf(tableName));
        tmp.printAll(tableName);
    }

    //nameという名前のテーブルを受取る
    public Table getTable(String name){
        int index;
        index = tableNames.indexOf(name);
        return tableList.get(index);
    }

    //全てのテーブルの名前を表示
    public void printAllName(){
        tableNames.printAllName();
    }

    //tableNameという名前のテーブルを削除
    public void delete(String tableName){
        int index;
        index = tableNames.indexOf(tableName);
        tableNames.remove(index);
        tableList.remove(index);
    }
    //初期の状態に戻す
    public void clear(){
        tableNames.clear();
        tableList.clear();
    }
}
