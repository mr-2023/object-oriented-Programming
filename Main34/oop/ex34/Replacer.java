package oop.ex34;

public class Replacer {
    public final int year, month, day;
    public Replacer(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String replace(String template){
        //.toString:null=nullpointerException
        //String.valueOf(): nullには、文字列nullを返す
        template = template.replaceAll("YYYY", String.valueOf(year));
        template = template.replaceAll("MM", String.format("%02d", month));
        template = template.replaceAll("DD", String.format("%02d", day));
        return template;
    }
}
