package src.main.java.dao;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class TimerReport extends Observable {
	
	private Timer timer;
	
	
	public void start(){
		TimerTask timerTask=new TimerTask() {
			
			@Override
			public void run() {
				setChanged();
				notifyObservers();
				System.out.println("UPDATE");
				
			}
		};
		timer=new Timer();
		timer.scheduleAtFixedRate(timerTask,5000,5000);
		
	}

}
