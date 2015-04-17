package exam.oop.test;

class Test1{
  static int a = 3;
  static int b;
  
  static void meth(int x) {
  	System.out.println("x = " + x);
  	System.out.println("a = " + a);
  	System.out.println("b = " + b);
  }
  
  static {
  	System.out.println("Static block initialized.");
  	b = a * 4;
  }
}

class Test {

	public static void main(String args[]) {
		Test1.meth(5);
	}

}
