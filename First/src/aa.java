
class Animal {
	String name;
	int age;
	public void eat() {
		System.out.println("³Ô¶«Î÷");
	}
	
}
class cat extends Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³ÔÓã");
	}
	
}

public class aa {
	public  static void main(String[] args) {
		Animal a = new cat();
		a.eat();
		
	}
}