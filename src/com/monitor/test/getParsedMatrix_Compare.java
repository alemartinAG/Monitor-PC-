package com.monitor.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import monitor.RdP;

class getParsedMatrix_Compare {
	
	int[][] matriz_1 = {
			{-1, 1},
			{1, -1},
			{0,  0}
		};

	int[][] matriz_2 = {
			{1, 0},
			{0, 1},
			{1,	0},
		};
	
	String desde_1;
	String hasta_1;
	
	String desde_2;
	String hasta_2;
	
	String path;

	@Test
	void test() {
		
		desde_1 = "Combined incidence matrix";
		hasta_1 = "Inhibition matrix";
		
		desde_2 = "Backwards incidence matrix";
		hasta_2 = desde_1;
		
		path = "/home/ale/Repositorios/Monitor-PC-/src/com/monitor/test/test_net.html";
		
		RdP petri = new RdP();
		
		//Verifico Matriz de Incidencia Combinada
		
		Vector<int[]> parsedMatrix = new Vector<int[]>();
		parsedMatrix = petri.getParsedMatrix(desde_1, hasta_1, path);
		
		for(int i=0; i<parsedMatrix.size(); i++) {
			for(int j=0; j<parsedMatrix.get(i).length; j++) {
				
				Assert.assertEquals(matriz_1[i][j], parsedMatrix.get(i)[j]);
				
			}
		}
		
		
		//Verifico Matriz de Incidencia Invertida
		
		parsedMatrix = petri.getParsedMatrix(desde_2, hasta_2, path);
		
		for(int i=0; i<parsedMatrix.size(); i++) {
			for(int j=0; j<parsedMatrix.get(i).length; j++) {
				
				Assert.assertEquals(matriz_2[i][j], parsedMatrix.get(i)[j]);
				
			}
		}
		
		
		
	}

}
