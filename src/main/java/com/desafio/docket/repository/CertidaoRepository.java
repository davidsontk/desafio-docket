package com.desafio.docket.repository;

import com.desafio.docket.model.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertidaoRepository extends JpaRepository <Certidao, Integer>  {
}
