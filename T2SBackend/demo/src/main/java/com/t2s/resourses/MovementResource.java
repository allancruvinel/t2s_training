package com.t2s.resourses;

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

import com.t2s.entities.Movement;
import com.t2s.services.MovementService;

@RestController
@RequestMapping(value = "/movements")
public class MovementResource {
	@Autowired
	private MovementService movementService;

	@GetMapping
	public ResponseEntity<List<Movement>> findAll() {
		return ResponseEntity.ok().body(movementService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Movement> findById(@PathVariable Long id){
		try {
		Optional<Movement> getOne = movementService.findById(id);
		Movement movement = getOne.get();
		return ResponseEntity.ok().body(movement);
		}catch(Exception e) {
			return new ResponseEntity<Movement>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Movement mv) {
		try {
		Movement moved = new Movement(mv.getContainer(),mv.getShip(),mv.getHandling());
		return ResponseEntity.ok().body("SUCCESS Created: ID:" + movementService.insert(mv).getId());
		} catch (RuntimeException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Movement mv) {
		try {
		return ResponseEntity.ok().body("SUCCESS Updated: ID " + movementService.update(id, mv).getId());
		} catch (RuntimeException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
		movementService.delete(id);
		return ResponseEntity.ok().body("SUCCESS Deleted: ID " + id);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
