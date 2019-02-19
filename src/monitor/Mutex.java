package monitor;

import java.util.concurrent.Semaphore;

public class Mutex {
	
	private Semaphore semaforo;
	
	public Mutex(){
		semaforo = new Semaphore(1); //TODO: Fairness
	}
	
	public void acquire() {
		
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void release() {
		semaforo.release();
	}
	
}
