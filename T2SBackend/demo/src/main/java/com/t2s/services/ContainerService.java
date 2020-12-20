package com.t2s.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2s.entities.Container;
import com.t2s.repositories.ContainerRepository;

@Service
public class ContainerService {
	
	@Autowired
	private ContainerRepository containerRepository;
	
	public List<Container> findAll() {
		return containerRepository.findAll();
	}
	public Optional<Container> findById(Long id) {
		return containerRepository.findById(id);
	}
	public Container insert(Container container) {
		return containerRepository.save(container);
	}
	
	public void delete(Long id) {
		containerRepository.deleteById(id);
	}
	
	public Container update(Long id,Container updatedContainer) {
		Container container = containerRepository.getOne(id);
		updateData(container,updatedContainer);
		return containerRepository.save(container);
	}
	
	public void updateData(Container container, Container newEntity) {
		container.setClient(newEntity.getClient());
		container.setCntr(newEntity.getCntr());
		container.setTypeContainer(newEntity.getTypeContainer());
		container.setStatus(newEntity.getStatus());
		container.setCategory(newEntity.getCategory());
	}
}
