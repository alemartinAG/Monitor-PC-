package monitor;

public class GestorDeMonitor {
	
	private boolean k = false;
	private int m = 0;
	
	private Mutex mutex;
	private RdP petrinet;
	private Colas colas;
	private Politicas politica;
	
	public GestorDeMonitor() {
		
		mutex = new Mutex();
		petrinet = new RdP();
		colas = new Colas();
		politica = new Politicas();
	
	}
	
	public void dispararTransicion() {
		
		if(mutex.acquire()) {
			k = true;
		}
		
		while(k) {
			
			k = petrinet.disparar();
			
			if(k) {
				
				petrinet.sensibilizadas();
				colas.quienesEstan();
				
				//m = Vs and Vc 
				
				if(m != 0) {
					
					politica.cual();
					colas.release();
				}
				else {
					
					k = false;
				}
			} 
			else {
				
				mutex.release();
				colas.acquire();
			}
		}
		
		mutex.release();
		
	}
	
	
	
}
