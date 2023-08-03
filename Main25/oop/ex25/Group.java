package oop.ex25;

public class Group implements Element{
    protected Element[] elems;//インターフェース型で宣言が出来る
    public Group(Element e1, Element e2){
        elems = new Element[2];
        elems[0] = e1;
        elems[1] = e2;
    }

    public Group(Element e1, Element e2, Element e3){
        elems = new Element[3];
        elems[0] = e1;
        elems[1] = e2;
        elems[2] = e3;
    }
    @Override
    public void move(int dx, int dy){
        for (Element l:elems){
            l.move(dx, dy);
        }
    }
    @Override
    public void print(){
        System.out.println("[");
        for (Element l:elems){
            l.print();
        }
        System.out.println("]");
    }
}