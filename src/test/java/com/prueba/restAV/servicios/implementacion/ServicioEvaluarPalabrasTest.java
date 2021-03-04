package com.prueba.restAV.servicios.implementacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class ServicioEvaluarPalabrasTest {

	@InjectMocks
	private ServicioEvaluarPalabras servicioEvaluarPalabras;
	
	@Test
	void testEvaluarPalabras() {
		String palabraA = "mary";
		String palabraB = "army";
		servicioEvaluarPalabras = new ServicioEvaluarPalabras();
		boolean prueba = servicioEvaluarPalabras.evaluarPalabras(palabraA, palabraB);
		
		assertEquals(true, prueba);
	}
	
	@Test
	void testEvaluarPalabrasNoCoinciden() {
		String palabraA = "mary";
		String palabraB = "Army";
		servicioEvaluarPalabras = new ServicioEvaluarPalabras();
		boolean prueba = servicioEvaluarPalabras.evaluarPalabras(palabraA, palabraB);
		
		assertEquals(false, prueba);
	}
	
	@Test
	void testEvaluarPalabrasDiferenteLongitud() {
		String palabraA = "mary";
		String palabraB = "aarmy";
		servicioEvaluarPalabras = new ServicioEvaluarPalabras();
		boolean prueba = servicioEvaluarPalabras.evaluarPalabras(palabraA, palabraB);
		
		assertEquals(false, prueba);
	}
}
