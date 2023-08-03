package oop.ex25;

public class Segment implements Element{
    int startX, startY, endX, endY;
    public Segment(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    @Override
    public void move(int dx, int dy){
        startX = startX + dx;
        startY = startY + dy;
        endX = endX + dx;
        endY = endY + dy;
    }
    @Override
    public void print(){
        System.out.printf("Segment: (%d, %d)-(%d, %d)\n", startX, startY, endX, endY);
    }
}