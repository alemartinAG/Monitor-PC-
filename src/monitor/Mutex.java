package monitor;

import java.util.concurrent.Semaphore;

public class Mutex {
	
	private Semaphore semaforo;
	
	public Mutex(){
		semaforo = new Semaphore(1); //TODO: Fairness
	}
	
	public boolean acquire() {
		try {
			semaforo.acquire();
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void release() {
		semaforo.release();
	}
	
}
