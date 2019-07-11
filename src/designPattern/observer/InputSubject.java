package designPattern.observer;

import java.util.LinkedList;
import java.util.List;

public class InputSubject implements Subject{

	String inputStr = "123";
	List<Observer>  obsList;
	public InputSubject() {
		obsList = new LinkedList<Observer>();
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i=0;i<obsList.size();i++) {
			obsList.get(i).update(inputStr);
		}
		
	}
	
	@Override
	public void addObs(Observer observer) {
		obsList.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		// TODO Auto-generated method stub
		obsList.remove(observer);
	}
	
	
	
}
