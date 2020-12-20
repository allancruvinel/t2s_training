package com.t2s.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.t2s.repositories.ContainerRepository;
import com.t2s.repositories.MovementRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private ContainerRepository containerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
			

		/*
		Container container = new Container("Santos Brasil","124521542",TypeContainer.T20,StatusContainer.FULL,CategoryContainer.IMPORT);
		containerRepository.save(container);
		Container container2 = new Container("Uziminas","dfsfsdfdfdsf",TypeContainer.T40,StatusContainer.EMPTY,CategoryContainer.IMPORT);
		containerRepository.save(container2);
		Container container3 = new Container("Petrobras","sdfsfsdfdsf",TypeContainer.T20,StatusContainer.EMPTY,CategoryContainer.EXPORT);
		containerRepository.save(container3);
		Container container4 = new Container("Joanie","sdfsdffsd",TypeContainer.T40,StatusContainer.FULL,CategoryContainer.EXPORT);
		containerRepository.save(container4);
		
		
		Movement movement = new Movement(container,"Orion S2s",Handling.DISCHARGE);
		movementRepository.save(movement);
		Movement movement2 = new Movement(container2,"Titanic",Handling.STACK);
		movementRepository.save(movement2);
		Movement movement3 = new Movement(container3,"TITANIC2",Handling.WEIGHING);
		movementRepository.save(movement3);
		*/
		System.out.println("ready to use");
		
		
	}

}
