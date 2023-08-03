package oop.ex5;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Recorder extends StringArrayManager implements Cloneable{
    //codeには、述語の後の部分を入れる
    public Recorder(LinkedList<String> fieldSaver){
        super(fieldSaver);
    }

    public Recorder(Scanner scanner){
        super(scanner);
    }


    @Override
    public void printAll() {
        System.out.println("+" + this.toString());
    }

    //このレコードのindex番目のフィールドがfieldであるか
    public boolean indexIsField(int index, String field){
        return stringSaver.get(index).equals(field);
    }

    //このレコードのindex番目のフィールドをfieldに変更
    public void update(int index, String field){
        stringSaver.set(index, field);
    }

    //このレコードのindex番目のフィールドを表示
    public String getField(int index){
        return stringSaver.get(index);
    }

    //このレコードの最後に新しくフィールドnewFieldを追加
    public void add(String newField){
        stringSaver.add(newField);
    }

    //このレコードと入力されたレコードをマージしたものを新しいレコードとしてそのレコードを返す
    public Recorder merge(Recorder recorder){
        Recorder mergedRecorder = this.clone();
        for(String tmp: recorder.toArray()){
            mergedRecorder.add(tmp);
        }
        return mergedRecorder;
    }

    //orderListの順番に従ってこのレコードのフィールドを並べかえたレコードを出力
    public Recorder getRecorderByOrder(ArrayList<Integer> orderList){
        LinkedList<String> tmp = new LinkedList<>();
        for(int i: orderList){
            tmp.add(stringSaver.get(i));
        }
        return new Recorder(tmp);
    }

    //このレコードのlinkedListを表示
    public LinkedList<String> toArray(){
        return stringSaver;
    }
    @Override
    public Recorder clone(){
        LinkedList<String> newArray = new LinkedList<>();
        if(stringSaver != null){
            for(String field:stringSaver){
                newArray.add(field);
            }
        }
        return new Recorder(newArray);
    }
}