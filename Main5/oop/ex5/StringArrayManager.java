package oop.ex5;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class StringArrayManager {
    protected LinkedList<String> stringSaver;

    abstract public void printAll();

    //codeには、述語の後の部分を入れる
    public StringArrayManager(LinkedList<String> fieldSaver){
        stringSaver = fieldSaver;
    }

    public StringArrayManager(Scanner scanner) {
        stringSaver = new LinkedList<>();
        while(scanner.hasNext()) {
            stringSaver.add(scanner.next());
        }
    }

    @Override
    public String toString() {
        String row = "";
        for (String element : stringSaver) {
            row = row + " " + element;
        }
        return row;
    }
}
