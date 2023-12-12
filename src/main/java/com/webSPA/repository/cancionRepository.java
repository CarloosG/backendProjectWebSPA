package com.webSPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webSPA.model.cancion;
@Repository
public interface cancionRepository extends JpaRepository<cancion, Long> {

}
