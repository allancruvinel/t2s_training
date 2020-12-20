package com.t2s.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2s.entities.Container;

public interface ContainerRepository extends JpaRepository<Container, Long> {

}
