package oop.ex5;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Column extends StringArrayManager implements IteratorInterface{
    //codeには、述語の後の部分を入れる
    public ListIterator<String> iter;
    public Column(Scanner scanner){
        super(scanner);
    }

    @Override
    public void printAll(){
        System.out.println("*" + this.toString());
    }
    //columnNameが入っている位置のインデックスを表示
    public int indexOf(String columnName){
        return stringSaver.indexOf(columnName);
    }

    //index番目のカラムをfieldに変更する
    public void update(int index, String field){
        stringSaver.set(index, field);
    }

    @Override
    public void initializeIter(){
        iter = stringSaver.listIterator(0);
    }

    @Override
    public String next(){
        if (iter.hasNext()){
            return iter.next();
        }
        return null;
    }

    //入力されたcolumnの各カラムが、このカラムのどこにあるのかをインデックスにして表示
    public ArrayList<Integer> getOrderByColumn(Column column){
        String columnName;
        ArrayList<Integer> orderList = new ArrayList<>();
        column.initializeIter();
        columnName = column.next();
        while(columnName != null){
            orderList.add(stringSaver.indexOf(columnName));
            columnName = column.next();
        }
        return orderList;
    }
}
