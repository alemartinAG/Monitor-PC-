package com.monitor.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import monitor.RdP;

class getParsedMatrix_Compare {
	
	RdP petri;
	
	int[][] matriz_1 = {
			{0, 0, 0},
			{0, 0, 0}
		};

	int[][] matriz_2 = {
			{0, 0, 0},
			{0, 0, 0}
		};
	
	String desde_1;
	String hasta_1;
	
	String desde_2;
	String hasta_2;
	
	@Before
	public void setUp() {
		
	petri = new RdP();
	
	desde_1 = "";
	hasta_1 = "";
	
	desde_2 = "";
	hasta_2 = "";
	
	}

	@Test
	void test() {
		
		Vector<int[]> parsedMatrix = petri.getParsedMatrix(desde_1, hasta_1);
		
		for(int i=0; i<parsedMatrix.size(); i++) {
			for(int j=0; j<parsedMatrix.get(i).length; j++) {
				
				Assert.assertEquals(matriz_1[i][j], parsedMatrix.get(i)[j]);
				
			}
		}
		
	}

}
