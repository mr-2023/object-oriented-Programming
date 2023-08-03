package oop.ex5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class StringArrayAssistance {
    private static ListIterator<String> iter1, iter2;
    private static int index1,index2;
    private static String field1, field2;
    //ArrayListのcolumnData1,columnData2のイテレーターの作成し、初期化
    //今どの要素を見ているかというインデックスカウンタも初期化
    public static void initializeIter(ArrayList<String> columnData1, ArrayList<String> columnData2){
        iter1 = columnData1.listIterator(0);
        iter2 = columnData2.listIterator(0);
        field1 = iter1.next();
        index1 = 0;
        index2 = 0;
    }
    //columnData1,columnData2の中で、一致したものを返す（イテレーター形式）
    public static ArrayList<Integer> getNextMatchingByArrays(){
        ArrayList<Integer> answerList = new ArrayList<>();
        while(iter1.hasNext()){
            while(iter2.hasNext()){
                field2 = iter2.next();
                if(field1.equals(field2)){
                    answerList.add(index1);
                    answerList.add(index2);
                    return answerList;
                }
                index2 += 1;
            }
            field1 = iter1.next();
            index1 += 1;
        }
        return null;
    }
}
