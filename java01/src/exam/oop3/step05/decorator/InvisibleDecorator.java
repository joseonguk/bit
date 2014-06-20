package exam.oop3.step05.decorator;

public class InvisibleDecorator extends Machine{
  Machine base;
  
  public InvisibleDecorator(Machine base) {
    this.base = base;
  }

  public void move() {
    base.move();
    System.out.println("자신을........ 감춘다....휘리릭....");
  }

}
