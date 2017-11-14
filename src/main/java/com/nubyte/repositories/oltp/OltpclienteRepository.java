package com.nubyte.repositories.oltp;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nubyte.model.oltp.Oltpcliente;

public interface OltpclienteRepository extends JpaRepository<Oltpcliente, BigDecimal> {

}
