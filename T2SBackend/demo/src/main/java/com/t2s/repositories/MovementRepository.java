package com.t2s.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.t2s.entities.Movement;
import com.t2s.entities.MovementReport;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	
	@Query(value = "Select tb_container.client as client,\r\n"
			+ "tb_container.category as category,\r\n"
			+ "tb_movement.handling as typemoviment,\r\n"
			+ "tb_movement.ship as ship,\r\n"
			+ "tb_movement.timestart as startmovement,\r\n"
			+ "  tb_movement.timeend as endmovement \r\n"
			+ "from tb_movement,tb_container \r\n"
			+ "where tb_container.id = tb_movement.container_id order by client, handling",nativeQuery = true)
	public List<String> innverJoinMovementReport();
}
