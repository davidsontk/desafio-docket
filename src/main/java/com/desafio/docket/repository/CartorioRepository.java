package com.desafio.docket.repository;

import com.desafio.docket.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {

}
