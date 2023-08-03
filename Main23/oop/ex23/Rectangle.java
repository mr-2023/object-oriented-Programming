package oop.ex23;

public class Rectangle extends Figure{
    private double width, height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return width * height;
    }
}