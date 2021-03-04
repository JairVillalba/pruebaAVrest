package com.prueba.restAV.servicios.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prueba.restAV.servicios.ServicioEvaluarPalabrasI;

@Service
public class ServicioEvaluarPalabras implements ServicioEvaluarPalabrasI {

	@Override
	public boolean evaluarPalabras( String palabraA, String palabraB ) {
		if ( palabraA.length() == palabraB.length() ) {
			return compararLetras( palabraA, palabraB );
		} else {
			return false;
		}
	}
	
	private boolean compararLetras( String palabraA, String palabraB ) {
		String[] letrasDeA = palabraA.split("");
		String[] letrasDeB = palabraB.split("");
		List<Object> letrasOrdenadasDeA = borrarLetrasRepetidas( letrasDeA );
		List<Object> letrasOrdenadasDeB = borrarLetrasRepetidas( letrasDeB );
		if ( letrasOrdenadasDeA.equals( letrasOrdenadasDeB ) ) {
			return true;
		}
		return false;
	}

	private List<Object> borrarLetrasRepetidas( String[] lista ) {
		List<Object> letras = new ArrayList<>();
		for (int i = 0; i < lista.length; i++) {
			if ( !letras.contains(lista[i]) ) {
				letras.add(lista[i]);
			}
		}
		letras = (List<Object>) letras.stream().sorted().collect(Collectors.toList()); 
		return letras;
	}
}
