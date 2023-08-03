package oop.ex45;


public class EvaluateVisitor implements Visitor {
  private Value v;

  public Value evaluate(Expression e) {
    e.accept(this);
    return v;
  }

  @Override
  public void visit(Number e){
    v = e;
  }

  @Override
  public void visit(Bool e){
    v = e;
  }

  @Override
  public void visit(Addition e){
    e.getRightExpression().accept(this);
    Value valueR = v;
    e.getLeftExpression().accept(this);
    v = new Number(valueR.getNumber() + v.getNumber());
  }

  @Override
  public void visit(LessThan e){
    e.getRightExpression().accept(this);
    Value valueR = v;
    e.getLeftExpression().accept(this);
    v = new Bool(v.getNumber() < valueR.getNumber());
  }

  @Override
  public void visit(IfThenElse e){
    e.getConditional().accept(this);
    if (v.getBool()) {
      e.getThenPart().accept(this);
    }else {
      e.getElsePart().accept(this);
    }
  }
}