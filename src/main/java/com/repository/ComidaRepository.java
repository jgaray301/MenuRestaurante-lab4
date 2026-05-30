package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long>{

}