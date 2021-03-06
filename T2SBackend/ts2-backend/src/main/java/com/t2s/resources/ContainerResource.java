package com.t2s.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2s.entities.Container;
import com.t2s.services.ContainerService;

@RestController
@RequestMapping(value = "/containers")
public class ContainerResource {
	
	@Autowired
	private ContainerService containerService;
	
	@GetMapping
	public ResponseEntity<List<Container>> findAll(){
		return ResponseEntity.ok().body(containerService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Container> findById(@PathVariable  Long id){
		try {
			Optional<Container> cat = containerService.findById(id);
			Container container = cat.get();
			return ResponseEntity.ok().body(container);
		}catch (Exception e) {
			return new ResponseEntity<Container>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insert (@RequestBody Container ct){
		try {
			return ResponseEntity.ok().body("SUCCESS CREATED!: id "+containerService.insert(ct).getId());
		}catch(RuntimeException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		try {
			containerService.delete(id);
			return ResponseEntity.ok().body("SUCCESS DELETED! ID: "+id);
		}catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<String> update (@PathVariable Long id,@RequestBody Container ct) throws Exception{
		try {
			return ResponseEntity.ok().body("SUCCESS Updated! ID: "+containerService.upDate(id, ct).getId());
		}catch(RuntimeException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
}
