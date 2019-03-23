package com.monitor.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import monitor.RdP;

class disparar_RdP {
	
	

	@Test
	void test() {
		
		RdP petri = new RdP();
		
		//TODO: Ver la posta
		Assert.assertTrue(petri.disparar(2));
		Assert.assertFalse(petri.disparar(0));
		
	}

}
