package monitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RdP {
	
	private BufferedReader br;
	private String textfile;
	private static final String BEG = "Combined incidence matrix"; 
	private static final String END = "Inhibition matrix";
	private static final String CELL = "\"cell\">";
	
	public RdP() {
		
		try{
			
			br = new BufferedReader(new FileReader("/home/ale/Repositorios/Monitor-PC-/src/monitor/Matrix.html"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    
		    textfile = sb.toString();
		    textfile = textfile.substring(textfile.indexOf(BEG), textfile.indexOf(END));
		    textfile = textfile.substring(textfile.indexOf(CELL)+CELL.length());
		    
		    //System.out.print(textfile);
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<String> matriz = new ArrayList<>();
		
		while(true) {
			
			try {
				
				textfile = textfile.substring(textfile.indexOf(CELL));
				matriz.add(textfile.substring(CELL.length(), textfile.indexOf("</")));
				textfile = textfile.substring(textfile.indexOf(CELL)+CELL.length());
				
				System.out.println(matriz.get(matriz.size()-1));
				
			} catch(IndexOutOfBoundsException e) {
				break;
			}
			
		}
		
		
	}
	
	public void sensibilizadas(){
		
	}
	
	public boolean disparar(){
		
		return false;
	}
	
}
