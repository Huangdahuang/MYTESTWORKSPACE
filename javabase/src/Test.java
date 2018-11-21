class Base {
	public void f() {
		System.out.println("Base1");
	}
	
}
class Sub extends Base {
	public void f() {
		System.out.println("Sub1");
	}
}
public class Test {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("Base");
			System.out.println(c+"..."+c.getName());
			Base b = (Base) c.newInstance();
			System.out.println(b+"..."+b.toString());
			b.f();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


