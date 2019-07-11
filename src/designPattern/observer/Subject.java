package designPattern.observer;

public interface Subject {
	
	public void addObs(Observer observer);
	public void remove(Observer observer);
	public void notifyObserver();
	
}
