package com.webSPA.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webSPA.exception.ResourceNotFoundException;
import com.webSPA.model.cancion;
import com.webSPA.repository.cancionRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin()
public class cancionController {
	@Autowired
	private cancionRepository cancionrepository;
	@GetMapping("/canciones/")
	public List<cancion> getAllCanciones(){
		return cancionrepository.findAll();
	}
	@PostMapping("/canciones/")
	public cancion createCancion(@RequestBody cancion cancion) {
		return cancionrepository.save(cancion);
	}
	@GetMapping("/canciones/{id}")
	public ResponseEntity<cancion>  getCancionById(@PathVariable Long id) {
		cancion cancion = cancionrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la cancion cuyo id es: " + id));
		return ResponseEntity.ok(cancion);
	}
	@PutMapping("/canciones/{id}")
	public ResponseEntity<cancion> updateCancion(@PathVariable Long id,@RequestBody cancion cancionDetails){
		cancion cancion = cancionrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la cancion cuyo id es: " + id));
		cancion.setNombreCancion(cancionDetails.getNombreCancion());
		cancion.setArtista(cancionDetails.getArtista());
		cancion.setAño(cancionDetails.getAño());
		cancion.setAlbum(cancionDetails.getAlbum());
		cancion.setCalificacion(cancionDetails.getCalificacion());
		
		cancion updatedCancion = cancionrepository.save(cancion);
		return ResponseEntity.ok(updatedCancion);

	}
	
	@DeleteMapping("/canciones/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCancion(@PathVariable Long id){
		cancion cancion = cancionrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la cancion cuyo id es: " + id));
	cancionrepository.delete(cancion);
	Map<String,Boolean> response = new HashMap<>();
	response.put("borrado", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

	
}
