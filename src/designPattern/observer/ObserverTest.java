package designPattern.observer;

public class ObserverTest {
	
	
	public static void main(String[] args) {
		InputSubject inpSub = new InputSubject();
		inpSub.addObs(new SayHelloObserver());
		inpSub.addObs(new SayHiObserver());
		
		inpSub.notifyObserver();
	}
	
}
