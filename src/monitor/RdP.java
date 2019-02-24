package monitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

public class RdP {
	
	private Vector<int[]> petriMatrix; 
	

	
	public RdP() {
		
		petriMatrix = new Vector<int[]>();
		petriMatrix = getMatrix();
		
		System.out.printf("\nCombined incidence matrix:\n\n");
		
		for(int i=0; i<petriMatrix.size(); i++) {
			for(int j=0; j<petriMatrix.get(i).length; j++) {
				System.out.printf("%2d ", petriMatrix.get(i)[j]);
			}
			
			System.out.println(" ");
		}
		
	}
	
	public void sensibilizadas(){
		
	}
	
	public boolean disparar(){
		
		return false;
	}
	
	private Vector<int[]> getMatrix(){
		
		BufferedReader br;
		String textfile = "";
		
		final String BEG = "Combined incidence matrix"; 
		final String END = "Inhibition matrix";
		final String CELL = "\"cell\">";
		
		int columnas = 0;
		
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
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Cuenta la cantidad de columnas
		final String KEYWRD = "colhead";
		String colheads = textfile.substring(0, textfile.indexOf("rowhead"));
		
		while(true) {
			
			try {
				
				//cuando no hay mas coincidencias tira la excepcion
				colheads.substring(colheads.indexOf(KEYWRD));
	
				colheads = colheads.substring(colheads.indexOf(KEYWRD) + KEYWRD.length());
			    
			} catch(IndexOutOfBoundsException e) {
				break;
			}
			
			columnas++;
		}
		
		//System.out.printf("\nCantidad de columnas = %d\n\n", columnas);
		
		Vector<int[]> matriz = new Vector<int[]>();
		
		
		while(true) {
			
			int[] col = new int[columnas];
			
			for(int i=0; i<columnas; i++) {
				
				try {
					
					//cuando no hay mas coincidencias tira la excepcion
					textfile = textfile.substring(textfile.indexOf(CELL));
					
					String number = textfile.substring(CELL.length(), textfile.indexOf("</")).trim();
					col[i] = Integer.parseInt(number);
					
					textfile = textfile.substring(textfile.indexOf(CELL)+CELL.length());
					
				} catch(IndexOutOfBoundsException e) {
					matriz.add(col);
					return matriz;
				}
				
			}
			
			matriz.add(col);
			
		}
		
	}
	
}
