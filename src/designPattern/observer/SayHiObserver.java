package designPattern.observer;

public class SayHiObserver implements Observer {

	@Override
	public void update(String inputString) {
		// TODO Auto-generated method stub
		System.out.println("Hi__"+inputString);
	}

}
