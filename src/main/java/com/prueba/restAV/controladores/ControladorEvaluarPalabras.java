package com.prueba.restAV.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.restAV.servicios.ServicioEvaluarPalabrasI;

@RestController
@RequestMapping("/evaluar")
public class ControladorEvaluarPalabras {

	@Autowired
	private ServicioEvaluarPalabrasI servicioEvaluarPalabras;
	
	@GetMapping(path = "/palabras", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> evaluarPalabras(@RequestParam String palabraA,
			@RequestParam String palabraB) {
		try {
			return ResponseEntity.ok(servicioEvaluarPalabras.evaluarPalabras(palabraA, palabraB));
		} catch (Exception e) {
			return null;
		}
	}
	
}
