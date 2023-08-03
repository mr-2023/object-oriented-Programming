package oop.ex5;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;

public class RecorderSaver implements IteratorInterface{
    private LinkedList<Recorder> recorderSaver = new LinkedList<>();
    private ListIterator<Recorder> iter;

    //Scannerの情報に従って新しいレコードを作り。このSaverに保存する
    public void add(Scanner scanner){
        recorderSaver.add(new Recorder(scanner));
    }

    //与えられたレコードをこのSaverに保存
    public void add(Recorder recorder){
        recorderSaver.add(recorder);
    }

    //与えられた複数のレコードを全てこのSaverに保存
    public void add(RecorderSaver newRecorders){
        newRecorders.initializeIter();
        Recorder tmp = newRecorders.next();
        while(tmp!=null){
            this.add(tmp);
            tmp = newRecorders.next();
        }
    }

    //このSaverのレコードのフィールドを全て表示する
    public void printAll(){
        if(! recorderSaver.isEmpty()) {
            for (Recorder recorder : recorderSaver) {
                recorder.printAll();
            }
        }
    }

    //index番目がfieldであるレコードのうち、一番手前にあるレコードを返す
    public Recorder search(int index, String field){
        for (Recorder tmp: recorderSaver){
            if (tmp.indexIsField(index, field)){
                return tmp;
            }
        }
        return null;
    }

    //レコーダーtmpをこのSaverから削除する
    public void remove(Recorder tmp){
        recorderSaver.remove(tmp);
    }
    @Override
    public void initializeIter(){
        iter = recorderSaver.listIterator(0);
    }

    @Override
    public Recorder next(){
        Recorder tmp;
        if(iter.hasNext()){
            tmp = iter.next();
            return tmp;
        }
        return null;
    }

    //index番目がfieldであるレコードのうち、一番手前にあるレコードを返し、その次にこれを呼び出すと、その続きから探す
    //最後まで探し終えると、nullを返す
    public Recorder searchIter(int index, String field){
        Recorder tmp;
        while(iter.hasNext()){
            tmp = iter.next();
            if(tmp.indexIsField(index, field)){
                return tmp;
            }
        }
        return null;
    }

    //このSaverの全てのレコードに対して、与えられたorderListによる並び替えを施したレコードを持ち、
    //それらを保持したSaverを返す
    public RecorderSaver getRecorderSaverByOrder(ArrayList<Integer> orderList){
        RecorderSaver tmpRecorders = new RecorderSaver();
        for(Recorder tmpRecorder:recorderSaver){
            tmpRecorders.add(tmpRecorder.getRecorderByOrder(orderList));
        }
        return tmpRecorders;
    }

    //このSaverのすべてのレコードのindex番目のフィールドをまとめて返す
    public ArrayList<String> getColumnData(int index){
        ArrayList<String> columnData= new ArrayList<>();
        for (Recorder tmp: recorderSaver){
            columnData.add(tmp.getField(index));
        }
        return columnData;
    }

    //index番目のレコードを返す
    public Recorder getRecorder(int index){
        return recorderSaver.get(index);
    }
}
