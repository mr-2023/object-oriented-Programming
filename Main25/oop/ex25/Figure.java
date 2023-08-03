package oop.ex25;

public abstract class Figure implements Element{
    protected int x, y;
    @Override
    public final void move(int dx, int dy){
        x = x + dx;
        y = y + dy;
    }
}