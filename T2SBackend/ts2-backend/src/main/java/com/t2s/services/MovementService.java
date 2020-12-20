package com.t2s.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2s.entities.Movement;
import com.t2s.repositories.MovementRepository;

@Service
public class MovementService {
	
	@Autowired
	private MovementRepository repository;
	
	public Movement insert (Movement movement) {
		return repository.save(movement);
	}
	
	public List<Movement> findAll(){
		return repository.findAll();
	}
	
	public Optional<Movement> findById(Long id){
		return repository.findById(id);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Movement upDate(Long id, Movement updatedMovement) throws Exception {
		Movement movement = repository.getOne(id);
		updateData(movement,updatedMovement);
		return repository.save(movement);
		
	}
	
	public void updateData(Movement movement, Movement newEntity) throws Exception {
		movement.setContainer(newEntity.getContainer());
		movement.setHandling(newEntity.getHandling());
		movement.setShip(newEntity.getShip());
		movement.setTimeend(newEntity.getTimeend());
		movement.setTimestart(newEntity.getTimestart());
		
	}
	
}
