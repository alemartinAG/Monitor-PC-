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
		petriMatrix = getParsedMatrix("Combined incidence matrix", "Inhibition matrix", "/home/ale/Repositorios/Monitor-PC-/src/monitor/Matrix.html");
		
		/*System.out.printf("\nCombined incidence matrix:\n\n");
		for(int i=0; i<petriMatrix.size(); i++) {
			for(int j=0; j<petriMatrix.get(i).length; j++) {
				System.out.printf("%2d ", petriMatrix.get(i)[j]);
			}
			System.out.println(" ");
		}*/
	}
	
	
	public void sensibilizadas(){
		
	}
	
	
	public boolean disparar(){
		
		return false;
	}
	
	
	//TODO:Ver si se puede dejar privado
	public Vector<int[]> getParsedMatrix(String desde, String hasta, String file){
		
		
		
		/*final String BEG = "Combined incidence matrix"; 
		final String END = "Inhibition matrix";*/
		
		String BEG = desde;
		String END = hasta;
		
		final String CELL = "\"cell\">";
		final String KEYWRD = "colhead";
		
		Vector<int[]> matriz = new Vector<int[]>();
		
		int columnas = 0;
		
		String textfile = "";
		
		textfile = getTextFromFile(file);
		
		//genero un substring de la porcion del texto que me interesa
		textfile = textfile.substring(textfile.indexOf(BEG), textfile.indexOf(END));
	    textfile = textfile.substring(textfile.indexOf(CELL)+CELL.length());
		
		
	    //Cuento la cantidad de columnas de la matriz
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
		
		
		/*Genero filas con los numeros parseados y luego
		 *agrego las mismas a la matriz de una por vez
		 */
		while(true) {
			
			int[] row = new int[columnas];
			
			for(int i=0; i<columnas; i++) {
				
				try {
					
					//cuando no hay mas coincidencias tira la excepcion
					textfile = textfile.substring(textfile.indexOf(CELL));
					
					String number = textfile.substring(CELL.length(), textfile.indexOf("</")).trim();
					row[i] = Integer.parseInt(number);
					
					
					
					textfile = textfile.substring(textfile.indexOf(CELL)+CELL.length());
					
				} catch(IndexOutOfBoundsException e) {
					//matriz.add(row);
					return matriz;
				}
				
			}
			
			matriz.add(row);	
		}	
	}
	
	
	private String getTextFromFile(String file) {
		
		String textfile = "";
		BufferedReader br;
		
		try{
			
			br = new BufferedReader(new FileReader(file));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    
		    textfile = sb.toString();
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return textfile;
	}
	
	
}
