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
	private MovementRepository movementRepository;
	
	public List<Movement> findAll() {
		return movementRepository.findAll();
	}
	public Optional<Movement> findById(Long id) {
		return movementRepository.findById(id);
	}
	public Movement insert(Movement movement) {
		return movementRepository.save(movement);
	}
	
	public void delete(Long id) {
		movementRepository.deleteById(id);
	}
	
	public Movement update(Long id,Movement updatedMovement) {
		Movement movement = movementRepository.getOne(id);
		updateData(movement,updatedMovement);
		return movementRepository.save(movement);
	}
	
	public void updateData(Movement movement, Movement newEntity) {
		movement.setContainer(newEntity.getContainer());
		movement.setHandling(newEntity.getHandling());
		movement.setShip(newEntity.getShip());
		movement.setTimeend(newEntity.getTimeend());
		movement.setTimestart(newEntity.getTimestart());
	}
}