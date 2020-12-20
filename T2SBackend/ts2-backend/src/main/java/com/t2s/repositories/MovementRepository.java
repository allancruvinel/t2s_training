package com.t2s.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.t2s.entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	 
	
	@Query(value="Select  tb_container.client as client,\r\n"
			+ " tb_container.category as category,\r\n"
			+ " tb_movement.handling as typemoviment,\r\n"
			+ " tb_movement.ship as ship, tb_movement.timestart as startmovement,\r\n"
			+ " tb_movement.timeend as endmovement from tb_movement,\r\n"
			+ "tb_container where tb_container.id = tb_movement.container_id order by client,\r\n"
			+ "handling\r\n"
			+ "",nativeQuery = true)
	public List<String> innerJoinMovementReport();
}
