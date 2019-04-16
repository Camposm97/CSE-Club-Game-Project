package threads;

public class Demo {

	public static void main(String[] args) {
		while (true) {
			MyThread t1 = new MyThread();
			t1.run();
		}
	}
}
