package oop.ex23;
import java.lang.Math;

public class Circle extends Figure{
    private double r;
    public Circle(double r){
        this.r = r;
    }
    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}