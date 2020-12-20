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
	private ContainerRepository repository;
	
	public Container insert (Container container) {
		return repository.save(container);
	}
	
	public List<Container> findAll(){
		return repository.findAll();
	}
	
	public Optional<Container> findById(Long id){
		return repository.findById(id);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Container upDate(Long id, Container updatedContainer) throws Exception {
		Container container = repository.getOne(id);
		updateData(container,updatedContainer);
		return repository.save(container);
		
	}
	
	public void updateData(Container container, Container newEntity) throws Exception {
		container.setClient(newEntity.getClient());
		container.setCntr(newEntity.getCntr());
		container.setTypeContainer(newEntity.getTypeContainer());
		container.setStatus(newEntity.getStatus());
		container.setCategory(newEntity.getCategory());
		
	}
	
}
