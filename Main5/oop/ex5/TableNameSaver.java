package oop.ex5;

import java.util.LinkedList;
import java.util.List;
//テーブルの名前を管理
public class TableNameSaver{
    static boolean isNewInstance = false;
    private List<String> tableNameSaver = new LinkedList<>();
    //Saverに管理されているテーブルの名前を全て表示
    public void printAllName(){
        System.out.println("Table List");
        if (isNewInstance){
            for (String tableName:tableNameSaver){
                System.out.println("- " + tableName);
            }
        }
    }

    //newNameという名前をSaverに登録する
    public void saveName(String newName){
        tableNameSaver.add(newName);
        isNewInstance = true;
    }

    //nameという名前のテーブルがある位置のインデックスを返す
    public int indexOf(String name){
        return tableNameSaver.indexOf(name);
    }

    //index番目のテーブルの名前を削除
    public void remove(int index){
        tableNameSaver.remove(index);
    }

    //tableNameがこのSaverに含まれているかどうか
    public boolean contains(String tableName){
        return tableNameSaver.contains(tableName);
    }

    public void clear(){
        tableNameSaver.clear();
    }
}
