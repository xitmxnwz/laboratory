package designPattern.observer;

public class SayHelloObserver implements Observer {

	@Override
	public void update(String inputString) {
		// TODO Auto-generated method stub
		System.out.println("Hello__"+inputString);
	}

}
