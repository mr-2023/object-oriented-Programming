package oop.ex25;

public class Circle extends Figure{
    int r;
    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    @Override
    public void print(){
        System.out.printf("Circle : (%d, %d), r=%d\n", x, y, r);
    }
}