package oop.ex5;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//テーブルの仕事を割り振る
public class Table {
    private RecorderSaver recorders = new RecorderSaver();
    private Column column;
    //codeには、述語の後の部分を入れる
    public Table(Scanner scanner){
        column = new Column(scanner);
    }

    //scannerにある情報(レコードの情報)をテーブルに追加(A B)
    public void insert(Scanner scanner){
        recorders.add(scanner);
    }

    //recorderをテーブルに追加
    public void insert(Recorder recorder){
        recorders.add(recorder);
    }

    //テーブルの名前とカラム名とフィールドを表示
    public void printAll(String tableName){
        System.out.format("Table %s\n",tableName);
        column.printAll();
        recorders.printAll();
    }

    //スキャナーの情報をもとにこのテーブルのレコーダーに変更を加える(A 4 A 3)
    public void update(Scanner scanner){
        int index = column.indexOf(scanner.next());
        Recorder tmp = recorders.search(index, scanner.next());
        index = column.indexOf(scanner.next());
        tmp.update(index, scanner.next());
    }

    //スキャナーの情報をもとにこのテーブルのレコードを消去(A 2)
    public void remove(Scanner scanner){
        Recorder tmp;
        String targetField;
        int index = column.indexOf(scanner.next());
        targetField = scanner.next();
        tmp = recorders.search(index, targetField);
        while(tmp != null){
            recorders.remove(tmp);
            tmp = recorders.search(index, targetField);
        }
    }

    //このテーブルを作成するのに必要なコードをfwを用いてコードに書き出す
    public void write(FileWriter fw, String tableName) throws IOException {
        Recorder tmp;
        fw.write("create "+ tableName + column.toString() + "\n");
        recorders.initializeIter();
        tmp = recorders.next();
        while(tmp != null){
            fw.write("insert "+ tableName + tmp.toString() + "\n");
            tmp = recorders.next();
        }
    }

    //Scannerの情報をもとにこのテーブルのあるカラムの名前を指定されたものに変更する
    public void rename(Scanner scanner){
        int index = column.indexOf(scanner.next());
        column.update(index, scanner.next());
    }

    //columnName列のフィールドがfieldNameであるレコードをtargetTableに追加する
    public void select(String columnName, String fieldName, Table targetTable){
        int index;
        Recorder tmp;
        recorders.initializeIter();
        index = column.indexOf(columnName);
        tmp = recorders.searchIter(index, fieldName);
        while(tmp != null){
            targetTable.insert(tmp.clone());
            tmp = recorders.searchIter(index, fieldName);
        }
    }

    //このテーブルのカラムにしたがってoriginalの列を並び替えた物をこのテーブルに追加
    public void copyByColumn(Table original){
        RecorderSaver tmpRecorder = original.getRecorderSaverByColumn(column);
        recorders.add(tmpRecorder);
    }

    //与えられたカラムにしたがってoriginalの列を並び替えたRecorderSaverを出力
    public RecorderSaver getRecorderSaverByColumn(Column orderColumn){
        ArrayList<Integer> columnOrder = column.getOrderByColumn(orderColumn);
        return recorders.getRecorderSaverByOrder(columnOrder);
    }

    //テーブルoriginalTable1のカラムcolumnName1のフィールドとテーブルoriginalTable2
    // のカラムcolumnName2のフィールドが一致するレコード通しをマージして、
    //このテーブルのレコードにしていく
    public void join(Table originalTable1, String columnName1, Table originalTable2, String columnName2){
        ArrayList<String> columnData1, columnData2;
        ArrayList<Integer> matching;
        Recorder recorder1, recorder2;
        Recorder mergedRecorder;
        columnData1 = originalTable1.getColumnData(columnName1);
        columnData2 = originalTable2.getColumnData(columnName2);
        StringArrayAssistance.initializeIter(columnData1, columnData2);
        matching = StringArrayAssistance.getNextMatchingByArrays();
        while(matching != null){
            recorder1 = originalTable1.getRecorder(matching.get(0));
            recorder2 = originalTable2.getRecorder(matching.get(1));
            mergedRecorder = recorder1.merge(recorder2);
            recorders.add(mergedRecorder);
            matching = StringArrayAssistance.getNextMatchingByArrays();
        }
    }

    //名前がcolumnNameのカラムのフィールドをまとめて得る
    public ArrayList<String> getColumnData(String columnName){
        int tmp;
        ArrayList<String> columnData;
        tmp = column.indexOf(columnName);
        columnData = recorders.getColumnData(tmp);
        return columnData;
    }

    //index番目のレコードを得る
    public Recorder getRecorder(int index){
        return recorders.getRecorder(index);
    }

}
